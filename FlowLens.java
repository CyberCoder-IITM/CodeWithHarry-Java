import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

/**
 * FlowLens - Offline PCAP Flow Forensics in pure Java (no external libs).
 *
 * Supports:
 * - PCAP (classic) little-endian capture files (most common)
 * - Ethernet + IPv4
 * - TCP/UDP basic parsing
 *
 * Usage:
 *   javac FlowLens.java
 *   java FlowLens path/to/file.pcap
 */
public class FlowLens {

    // ---- Data Models ----

    enum L4Proto { TCP, UDP, OTHER }

    static final class FlowKey {
        final String srcIp, dstIp;
        final int srcPort, dstPort;
        final L4Proto proto;

        FlowKey(String srcIp, String dstIp, int srcPort, int dstPort, L4Proto proto) {
            this.srcIp = srcIp;
            this.dstIp = dstIp;
            this.srcPort = srcPort;
            this.dstPort = dstPort;
            this.proto = proto;
        }

        @Override public boolean equals(Object o) {
            if (!(o instanceof FlowKey)) return false;
            FlowKey fk = (FlowKey) o;
            return srcPort == fk.srcPort && dstPort == fk.dstPort
                    && Objects.equals(srcIp, fk.srcIp)
                    && Objects.equals(dstIp, fk.dstIp)
                    && proto == fk.proto;
        }

        @Override public int hashCode() {
            return Objects.hash(srcIp, dstIp, srcPort, dstPort, proto);
        }

        @Override public String toString() {
            return proto + " " + srcIp + ":" + srcPort + " -> " + dstIp + ":" + dstPort;
        }
    }

    static final class FlowStats {
        long packets = 0;
        long bytes = 0;
        long firstTsMicros = Long.MAX_VALUE;
        long lastTsMicros = Long.MIN_VALUE;

        // TCP flags
        long syn = 0, fin = 0, rst = 0, ack = 0;

        void update(long tsMicros, int caplen, int tcpFlags) {
            packets++;
            bytes += caplen;
            firstTsMicros = Math.min(firstTsMicros, tsMicros);
            lastTsMicros = Math.max(lastTsMicros, tsMicros);

            if (tcpFlags >= 0) {
                if ((tcpFlags & 0x02) != 0) syn++;
                if ((tcpFlags & 0x01) != 0) fin++;
                if ((tcpFlags & 0x04) != 0) rst++;
                if ((tcpFlags & 0x10) != 0) ack++;
            }
        }

        double durationSeconds() {
            if (firstTsMicros == Long.MAX_VALUE || lastTsMicros == Long.MIN_VALUE) return 0.0;
            return Math.max(0.0, (lastTsMicros - firstTsMicros) / 1_000_000.0);
        }
    }

    // ---- PCAP Parsing Helpers ----

    static final class PcapGlobalHeader {
        int magic;
        short versionMajor;
        short versionMinor;
        int thisZone;
        int sigFigs;
        int snapLen;
        int network;
    }

    static final class PcapRecordHeader {
        int tsSec;
        int tsUsec;
        int inclLen;
        int origLen;
    }

    // Ethernet
    static final int ETH_HEADER_LEN = 14;
    static final int ETH_TYPE_IPV4 = 0x0800;

    // IPv4
    static final int IPPROTO_TCP = 6;
    static final int IPPROTO_UDP = 17;

    // ---- Main ----

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java FlowLens <file.pcap>");
            System.exit(1);
        }

        File f = new File(args[0]);
        if (!f.exists() || !f.isFile()) {
            System.err.println("File not found: " + f.getAbsolutePath());
            System.exit(1);
        }

        try (InputStream in = new BufferedInputStream(new FileInputStream(f))) {
            PcapGlobalHeader gh = readGlobalHeader(in);
            if (gh == null) {
                System.err.println("Failed to read PCAP global header.");
                System.exit(1);
            }

            // For simplicity, we assume classic PCAP little-endian (most common).
            // If your file is big-endian, this will refuse to proceed.
            if (!isLittleEndianMagic(gh.magic)) {
                System.err.println("Unsupported PCAP byte order/magic: 0x" + Integer.toHexString(gh.magic));
                System.err.println("Tip: export as classic PCAP little-endian from Wireshark/tcpdump.");
                System.exit(1);
            }

            if (gh.network != 1) { // 1 = DLT_EN10MB (Ethernet)
                System.err.println("Unsupported link-layer type (network): " + gh.network + " (expected 1 = Ethernet)");
                System.exit(1);
            }

            Map<FlowKey, FlowStats> flows = new HashMap<>();
            Map<String, Long> hostBytes = new HashMap<>();
            Map<String, Set<Integer>> srcToDstPorts = new HashMap<>(); // scan heuristic

            long totalPackets = 0;
            long totalBytes = 0;

            while (true) {
                PcapRecordHeader rh = readRecordHeader(in);
                if (rh == null) break;

                byte[] pkt = readExactly(in, rh.inclLen);
                if (pkt == null) break;

                totalPackets++;
                totalBytes += rh.inclLen;

                long tsMicros = (rh.tsSec * 1_000_000L) + (rh.tsUsec & 0xffffffffL);

                // Minimal checks
                if (pkt.length < ETH_HEADER_LEN) continue;

                int ethType = u16(pkt, 12);
                if (ethType != ETH_TYPE_IPV4) continue;

                // IPv4 starts at offset 14
                int ipOff = ETH_HEADER_LEN;
                if (pkt.length < ipOff + 20) continue;

                int versionIhl = u8(pkt, ipOff);
                int version = (versionIhl >> 4) & 0xF;
                int ihl = (versionIhl & 0xF) * 4;
                if (version != 4 || ihl < 20) continue;
                if (pkt.length < ipOff + ihl) continue;

                int protocol = u8(pkt, ipOff + 9);

                String srcIp = ipv4ToString(pkt, ipOff + 12);
                String dstIp = ipv4ToString(pkt, ipOff + 16);

                // Count host bytes (talkers)
                hostBytes.merge(srcIp, (long) rh.inclLen, Long::sum);
                hostBytes.merge(dstIp, (long) rh.inclLen, Long::sum);

                int l4Off = ipOff + ihl;
                if (protocol == IPPROTO_TCP) {
                    if (pkt.length < l4Off + 20) continue;

                    int srcPort = u16(pkt, l4Off);
                    int dstPort = u16(pkt, l4Off + 2);

                    int dataOffset = ((u8(pkt, l4Off + 12) >> 4) & 0xF) * 4;
                    if (dataOffset < 20) continue;

                    int flags = u8(pkt, l4Off + 13);

                    FlowKey key = new FlowKey(srcIp, dstIp, srcPort, dstPort, L4Proto.TCP);
                    flows.computeIfAbsent(key, k -> new FlowStats()).update(tsMicros, rh.inclLen, flags);

                    // scan heuristic: how many distinct destination ports did a source hit?
                    srcToDstPorts.computeIfAbsent(srcIp, k -> new HashSet<>()).add(dstPort);

                } else if (protocol == IPPROTO_UDP) {
                    if (pkt.length < l4Off + 8) continue;

                    int srcPort = u16(pkt, l4Off);
                    int dstPort = u16(pkt, l4Off + 2);

                    FlowKey key = new FlowKey(srcIp, dstIp, srcPort, dstPort, L4Proto.UDP);
                    flows.computeIfAbsent(key, k -> new FlowStats()).update(tsMicros, rh.inclLen, -1);

                    srcToDstPorts.computeIfAbsent(srcIp, k -> new HashSet<>()).add(dstPort);

                } else {
                    // Ignore other protocols for now
                }
            }

            printReport(f.getName(), totalPackets, totalBytes, flows, hostBytes, srcToDstPorts);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(2);
        }
    }

    // ---- Reporting ----

    static void printReport(String filename,
                            long totalPackets,
                            long totalBytes,
                            Map<FlowKey, FlowStats> flows,
                            Map<String, Long> hostBytes,
                            Map<String, Set<Integer>> srcToDstPorts) {

        System.out.println("\n=== FlowLens Report ===");
        System.out.println("File           : " + filename);
        System.out.println("Total packets  : " + totalPackets);
        System.out.println("Total bytes    : " + totalBytes);
        System.out.println("Parsed flows   : " + flows.size());

        // Top flows by bytes
        List<Map.Entry<FlowKey, FlowStats>> flowList = new ArrayList<>(flows.entrySet());
        flowList.sort((a, b) -> Long.compare(b.getValue().bytes, a.getValue().bytes));

        System.out.println("\n--- Top 10 Flows (by bytes) ---");
        for (int i = 0; i < Math.min(10, flowList.size()); i++) {
            var e = flowList.get(i);
            FlowKey k = e.getKey();
            FlowStats s = e.getValue();

            String extra = "";
            if (k.proto == L4Proto.TCP) {
                extra = String.format(" | TCP flags: SYN=%d ACK=%d RST=%d FIN=%d", s.syn, s.ack, s.rst, s.fin);
            }

            System.out.printf("%2d) %-45s | pkts=%-6d bytes=%-10d dur=%.3fs%s%n",
                    (i + 1), k.toString(), s.packets, s.bytes, s.durationSeconds(), extra);
        }

        // Top talkers by bytes
        List<Map.Entry<String, Long>> hosts = new ArrayList<>(hostBytes.entrySet());
        hosts.sort((a, b) -> Long.compare(b.getValue(), a.getValue()));

        System.out.println("\n--- Top 10 Talkers (by bytes observed) ---");
        for (int i = 0; i < Math.min(10, hosts.size()); i++) {
            var e = hosts.get(i);
            System.out.printf("%2d) %-16s | bytes=%d%n", (i + 1), e.getKey(), e.getValue());
        }

        // Simple anomaly heuristics
        System.out.println("\n--- Heuristics (not a verdict) ---");

        // 1) SYN-heavy TCP flows
        int synHeavyCount = 0;
        for (var e : flows.entrySet()) {
            if (e.getKey().proto != L4Proto.TCP) continue;
            FlowStats s = e.getValue();
            // SYNs with very low ACKs can indicate scan-ish behavior (very rough)
            if (s.syn >= 10 && s.ack == 0) {
                if (synHeavyCount == 0) System.out.println("SYN-heavy flows (SYN>=10 and ACK=0):");
                synHeavyCount++;
                System.out.println("  - " + e.getKey() + " | SYN=" + s.syn + " pkts=" + s.packets);
                if (synHeavyCount >= 10) break;
            }
        }
        if (synHeavyCount == 0) System.out.println("No obvious SYN-heavy flows detected.");

        // 2) Many distinct destination ports from one source (port scan-ish)
        List<Map.Entry<String, Set<Integer>>> portSpread = new ArrayList<>(srcToDstPorts.entrySet());
        portSpread.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

        int shown = 0;
        for (var e : portSpread) {
            int distinct = e.getValue().size();
            if (distinct >= 50) { // heuristic threshold
                if (shown == 0) System.out.println("\nSources with many distinct destination ports (>=50):");
                shown++;
                System.out.println("  - " + e.getKey() + " | distinct dst ports=" + distinct);
                if (shown >= 10) break;
            }
        }
        if (shown == 0) System.out.println("No obvious high port-spread sources detected.");

        System.out.println("\n=== End of Report ===\n");
    }

    // ---- PCAP Readers (Little Endian) ----

    static boolean isLittleEndianMagic(int magic) {
        // classic PCAP little endian: d4 c3 b2 a1 -> 0xa1b2c3d4 when read LE
        // but since we read as LE below, it should match 0xa1b2c3d4
        return magic == 0xa1b2c3d4;
    }

    static PcapGlobalHeader readGlobalHeader(InputStream in) throws IOException {
        byte[] b = readExactly(in, 24);
        if (b == null) return null;

        ByteBuffer bb = ByteBuffer.wrap(b).order(ByteOrder.LITTLE_ENDIAN);
        PcapGlobalHeader gh = new PcapGlobalHeader();
        gh.magic = bb.getInt();
        gh.versionMajor = bb.getShort();
        gh.versionMinor = bb.getShort();
        gh.thisZone = bb.getInt();
        gh.sigFigs = bb.getInt();
        gh.snapLen = bb.getInt();
        gh.network = bb.getInt();
        return gh;
    }

    static PcapRecordHeader readRecordHeader(InputStream in) throws IOException {
        byte[] b = readExactly(in, 16);
        if (b == null) return null;

        ByteBuffer bb = ByteBuffer.wrap(b).order(ByteOrder.LITTLE_ENDIAN);
        PcapRecordHeader rh = new PcapRecordHeader();
        rh.tsSec = bb.getInt();
        rh.tsUsec = bb.getInt();
        rh.inclLen = bb.getInt();
        rh.origLen = bb.getInt();

        if (rh.inclLen < 0 || rh.inclLen > 10_000_000) {
            // sanity check
            return null;
        }
        return rh;
    }

    static byte[] readExactly(InputStream in, int n) throws IOException {
        byte[] buf = new byte[n];
        int off = 0;
        while (off < n) {
            int r = in.read(buf, off, n - off);
            if (r == -1) return null;
            off += r;
        }
        return buf;
    }

    // ---- Byte Helpers ----

    static int u8(byte[] b, int off) {
        return b[off] & 0xFF;
    }

    static int u16(byte[] b, int off) {
        return ((b[off] & 0xFF) << 8) | (b[off + 1] & 0xFF);
    }

    static String ipv4ToString(byte[] b, int off) {
        return (b[off] & 0xFF) + "." + (b[off + 1] & 0xFF) + "." + (b[off + 2] & 0xFF) + "." + (b[off + 3] & 0xFF);
    }
}
