import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A simple, independent dictionary attack simulator in pure Java.
 * This tool demonstrates how brute-force password cracking works.
 */
public class DictionaryAttacker {

    // --- The Attack Target ---
    // This is the SHA-256 hash we are trying to crack.
    // The plain text password is "password123"
    public static final String TARGET_HASH = "ef92b778bafe771e89245b89ecbc08a44a4e166c0520353239c9f759a5d10569";

    // --- The Attacker's Dictionary ---
    // In a real attack, this list would have millions or billions of words.
    public static final String[] WORDLIST = {
        "hello",
        "123456",
        "admin",
        "qwerty",
        "password",
        "sunshine",
        "iloveyou",
        "password123", // The correct password is in our list
        "test",
        "java"
    };

    /**
     * Helper function to convert a byte array into a hexadecimal string.
     */
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * Calculates the SHA-256 hash of a given string.
     */
    public static String getSha256Hash(String text) {
        try {
            // Get an instance of the SHA-256 message digest algorithm
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            // Calculate the hash
            byte[] encodedHash = digest.digest(
                text.getBytes(StandardCharsets.UTF_8));
            
            // Convert the byte array to a hex string
            return bytesToHex(encodedHash);
            
        } catch (NoSuchAlgorithmException e) {
            // This should never happen with "SHA-256"
            System.err.println("Error: SHA-256 algorithm not found.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Main attack loop.
     */
    public static void main(String[] args) {
        System.out.println("--- Dictionary Attack Simulator ---");
        System.out.println("Target Hash: " + TARGET_HASH);
        System.out.println("Wordlist Size: " + WORDLIST.length + " words");
        System.out.println("Starting attack...\n");

        long startTime = System.currentTimeMillis();
        boolean passwordFound = false;

        // Loop through every word in the dictionary
        for (String guess : WORDLIST) {
            // Hash the word from our list
            String guessHash = getSha256Hash(guess);

            // Optional: Uncomment to see the full process
            // System.out.println("Trying: " + guess + " -> " + guessHash);

            // Compare the generated hash to our target hash
            if (TARGET_HASH.equals(guessHash)) {
                System.out.println("\n!!! PASSWORD FOUND !!!");
                System.out.println("Plain text: " + guess);
                System.out.println("Hash: " + guessHash);
                passwordFound = true;
                break; // Stop the attack once we find it
            }
        }

        long endTime = System.currentTimeMillis();
        double totalTime = (endTime - startTime) / 1000.0;

        if (!passwordFound) {
            System.out.println("\n--- Attack Failed ---");
            System.out.println("Password not found in the wordlist.");
        }

        System.out.printf("\nScan completed in %.4f seconds.\n", totalTime);
    }
}