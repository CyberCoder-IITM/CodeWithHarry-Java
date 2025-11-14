import java.util.BitSet;
import java.util.Objects;

/**
 * Main class to demonstrate the Bloom Filter.
 * This class contains the main method to run the browser security simulation.
 */
public class BrowserSecurityDemo {

    public static void main(String[] args) {
        
        // 1. SETUP
        // We use a small filter (20 bits, 2 hash functions)
        // to easily demonstrate a false positive.
        SimpleBloomFilter badUrlFilter = new SimpleBloomFilter(20, 2);

        System.out.println("--- Browser is downloading the malicious URL filter... ---");
        
        // The security provider (e.g., Google) has pre-filled the filter
        // with known malicious sites.
        
        // "malware.com" hashes to bits 5 and 2
        badUrlFilter.add("malware.com"); 
        
        // "phishing.org" hashes to bits 3 and 5
        badUrlFilter.add("phishing.org"); 

        System.out.println("--- Filter download complete. User starts browsing. ---");
        
        // 2. USER BROWSING (Scenarios)

        // Scenario 1: A safe site
        // "google.com" hashes to bits 10 and 7. Both are 0.
        browseTo("google.com", badUrlFilter);

        // Scenario 2: A known malicious site
        // "malware.com" hashes to bits 5 and 2. Both are 1.
        browseTo("malware.com", badUrlFilter);
        
        // Scenario 3: A FALSE POSITIVE
        // "innocent-site.com" hashes to bits 2 and 3.
        // Bit 2 was set by "malware.com".
        // Bit 3 was set by "phishing.org".
        // The filter will *incorrectly* flag this safe site.
        browseTo("innocent-site.com", badUrlFilter);
    }

    /**
     * Helper method to simulate a user visiting a URL.
     * It checks the filter and prints a user-friendly message.
     */
    public static void browseTo(String url, SimpleBloomFilter filter) {
        System.out.println("\nUser tries to visit: " + url);
        boolean isMalicious = filter.check(url);

        if (isMalicious) {
            System.out.println(">>> [WARN!] Page blocked: '" + url + "' is *probably* malicious.");
            System.out.println("    (In a real browser, a full, slow check would now confirm this.)");
        } else {
            System.out.println(">>> [OK] Page is safe: '" + url + "'. Loading page...");
        }
    }
}

/**
 * A simple demonstration of a Bloom Filter in Java.
 * This is a package-private class (no 'public' modifier) 
 * so it can live in the same file as BrowserSecurityDemo.
 */
class SimpleBloomFilter {

    private final BitSet bitSet;
    private final int bitSetSize;
    private final int numHashFunctions;

    public SimpleBloomFilter(int bitSetSize, int numHashFunctions) {
        this.bitSetSize = bitSetSize;
        this.numHashFunctions = numHashFunctions;
        this.bitSet = new BitSet(bitSetSize); 
    }

    /**
     * Adds an item to the Bloom Filter.
     */
    public void add(String item) {
        System.out.println("Adding to filter: '" + item + "'");
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = getHash(item, i);
            bitSet.set(hash);
        }
        System.out.println("  -> Filter state: " + bitSet);
    }

    /**
     * Checks if an item is "probably" in the set.
     */
    public boolean check(String item) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = getHash(item, i);
            
            // Check if the bit is 0
            if (!bitSet.get(hash)) {
                return false; // Definitely not in the set
            }
        }
        // All bits were 1, so it's *probably* in the set
        return true; 
    }

    /**
     * A helper method to generate multiple hash values for an item.
     */
    private int getHash(String item, int seed) {
        int hashCode = Objects.hash(item, seed);
        return Math.abs(hashCode) % bitSetSize;
    }
}