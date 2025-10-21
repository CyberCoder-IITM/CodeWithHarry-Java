import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.io.IOException;

public class PortScanner {

    public static void main(String[] args) {
        // --- Argument Validation ---
        if (args.length != 3) {
            printUsage();
            System.exit(1);
        }

        String host = args[0];
        int startPort;
        int endPort;

        try {
            startPort = Integer.parseInt(args[1]);
            endPort = Integer.parseInt(args[2]);

            if (startPort < 1 || endPort > 65535 || startPort > endPort) {
                System.err.println("Error: Invalid port range. Must be between 1 and 65535.");
                printUsage();
                System.exit(1);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: Port numbers must be integers.");
            printUsage();
            System.exit(1);
            return;
        }

        // --- Port Scanning Logic ---
        System.out.println("Scanning host '" + host + "' from port " + startPort + " to " + endPort + "...\n");

        for (int port = startPort; port <= endPort; port++) {
            try {
                // Try to connect to the host on the current port with a timeout.
                // Using try-with-resources to ensure the socket is always closed.
                try (Socket socket = new Socket()) {
                    // Set a timeout (e.g., 200 milliseconds) so it doesn't hang
                    // on ports that are filtered or slow to respond.
                    socket.connect(new InetSocketAddress(host, port), 200);
                }
                
                // If the connection was successful, the port is open.
                System.out.println("Port " + port + ": OPEN");
                
            } catch (UnknownHostException e) {
                // Handle case where the host cannot be resolved
                System.err.println("Error: Unknown host: " + host);
                System.exit(1);
            } catch (SocketTimeoutException e) {
                // A timeout means the port is likely closed or filtered.
                // We'll just ignore it to keep the output clean.
            } catch (IOException e) {
                // An IOException (like 'Connection refused') means the port is closed.
                // We'll also ignore this and only report open ports.
            }
        }

        System.out.println("\nScan complete.");
    }

    /**
     * Prints the correct command-line usage of the program.
     */
    private static void printUsage() {
        System.err.println("Usage: java PortScanner <HostName> <StartPort> <EndPort>");
        System.err.println("Example: java PortScanner localhost 1 1024");
    }
}