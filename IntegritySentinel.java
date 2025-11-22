import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.*;

/**
 * IntegritySentinel - A File Integrity Monitoring (FIM) Tool.
 * * CONCEPT:
 * This program acts as a "tripwire" for a directory. 
 * 1. It creates a "baseline" by calculating the SHA-256 hash of every file.
 * 2. It can later scan the directory again to detect:
 * - MODIFIED files (Hash mismatch)
 * - NEW files (Intrusion)
 * - DELETED files (Data loss)
 */
public class IntegritySentinel {

    // File to store the baseline hashes
    private static final String BASELINE_FILE = "baseline.txt";

    public static void main(String[] args) {
        // Hardcoded path for demo purposes (Change this to a folder you want to watch)
        String targetDirectory = "./watch_folder"; 

        // Simple menu CLI
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- INTEGRITY SENTINEL [FIM] ---");
        System.out.println("1. Create New Baseline (Snapshot)");
        System.out.println("2. Verify Integrity (Scan)");
        System.out.print("Select Mode: ");
        
        String choice = scanner.nextLine();

        try {
            if (choice.equals("1")) {
                createBaseline(targetDirectory);
            } else if (choice.equals("2")) {
                verifyIntegrity(targetDirectory);
            } else {
                System.out.println("Invalid option.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // --- MODE 1: Create Baseline ---
    private static void createBaseline(String path) throws IOException, Exception {
        File folder = new File(path);
        if (!folder.exists()) folder.mkdirs();

        Map<String, String> baseline = new HashMap<>();
        File[] files = folder.listFiles();

        System.out.println("Calculating hashes for " + folder.getAbsolutePath() + "...");

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && !file.getName().equals(BASELINE_FILE)) {
                    String hash = calculateSHA256(file);
                    baseline.put(file.getName(), hash);
                    System.out.println("[ADDED] " + file.getName());
                }
            }
        }

        saveBaseline(baseline);
        System.out.println("Baseline saved to " + BASELINE_FILE);
    }

    // --- MODE 2: Verify Integrity ---
    private static void verifyIntegrity(String path) throws IOException, Exception {
        Map<String, String> oldBaseline = loadBaseline();
        File folder = new File(path);
        File[] files = folder.listFiles();
        
        Set<String> currentFiles = new HashSet<>();
        boolean compromiseDetected = false;

        System.out.println("Scanning for unauthorized changes...");

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && !file.getName().equals(BASELINE_FILE)) {
                    String fileName = file.getName();
                    currentFiles.add(fileName);
                    String currentHash = calculateSHA256(file);

                    if (!oldBaseline.containsKey(fileName)) {
                        System.out.println(" ALERT: New Unknown File Detected: " + fileName);
                        compromiseDetected = true;
                    } else {
                        String oldHash = oldBaseline.get(fileName);
                        if (!oldHash.equals(currentHash)) {
                            System.out.println(" CRITICAL: File Modified! " + fileName);
                            System.out.println("   Expected: " + oldHash);
                            System.out.println("   Actual:   " + currentHash);
                            compromiseDetected = true;
                        }
                    }
                }
            }
        }

        // Check for deletions
        for (String oldFile : oldBaseline.keySet()) {
            if (!currentFiles.contains(oldFile)) {
                System.out.println(" ALERT: File Deleted: " + oldFile);
                compromiseDetected = true;
            }
        }

        if (!compromiseDetected) {
            System.out.println(" System Secure. No changes detected.");
        }
    }

    // --- UTILITIES ---

    private static String calculateSHA256(File file) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream(file);
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        }
        fis.close();

        byte[] bytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private static void saveBaseline(Map<String, String> map) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(BASELINE_FILE));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            writer.write(entry.getKey() + "=" + entry.getValue());
            writer.newLine();
        }
        writer.close();
    }

    private static Map<String, String> loadBaseline() throws IOException {
        Map<String, String> map = new HashMap<>();
        File file = new File(BASELINE_FILE);
        if (!file.exists()) return map;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("=");
            if (parts.length == 2) {
                map.put(parts[0], parts[1]);
            }
        }
        reader.close();
        return map;
    }
}
