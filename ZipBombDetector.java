import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

//Insights

/**
 * ZipBombDetector - A Defensive Security Utility.
 * * CONCEPT:
 * A "Zip Bomb" is a malicious archive file designed to crash the system 
 * or fill up the disk when decompressed. 
 * * This tool calculates the "Compression Ratio" of a zip file without 
 * actually extracting it. If the ratio is suspiciously high (e.g., > 100:1),
 * it flags the file as dangerous.
 */
public class ZipBombDetector {

    // Threshold: If uncompressed size is 100x bigger than compressed size, it's a bomb.
    private static final long THRESHOLD_RATIO = 100; 
    
    // Safety Limit: Flag if total unzipped size exceeds 1 GB (for this demo)
    private static final long MAX_SAFE_SIZE = 1024 * 1024 * 1024; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- ZIP BOMB DETECTOR [Malware Analysis] ---");
        System.out.print("Enter path to .zip file: ");
        String filePath = scanner.nextLine();
        
        File file = new File(filePath);
        if (!file.exists() || !filePath.endsWith(".zip")) {
            System.out.println("Error: Invalid file path or not a .zip file.");
            return;
        }

        try {
            scanZipFile(file);
        } catch (Exception e) {
            System.err.println("Error scanning file: " + e.getMessage());
        }
    }

    private static void scanZipFile(File file) throws IOException {
        try (ZipFile zipFile = new ZipFile(file)) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            
            long totalCompressed = 0;
            long totalUncompressed = 0;
            boolean isBomb = false;

            System.out.println("Analyzing archive structure...");

            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                
                // Skip directories
                if (entry.isDirectory()) continue;

                long compressed = entry.getCompressedSize();
                long uncompressed = entry.getSize();

                // Validating data availability
                if (compressed == -1 || uncompressed == -1) {
                    System.out.println("⚠️  Warning: Size info missing for " + entry.getName());
                    continue;
                }

                totalCompressed += compressed;
                totalUncompressed += uncompressed;

                // Calculate ratio for this specific file
                // Avoid division by zero
                long ratio = (compressed > 0) ? (uncompressed / compressed) : 0;

                if (ratio > THRESHOLD_RATIO) {
                    System.out.println("🚨 SUSPICIOUS FILE: " + entry.getName());
                    System.out.println("   Ratio: " + ratio + ":1 (Compressed: " + compressed + " bytes -> Unzipped: " + uncompressed + " bytes)");
                    isBomb = true;
                }
            }

            // Global Analysis
            System.out.println("\n--- ANALYSIS RESULT ---");
            System.out.println("Total Compressed Size:   " + (totalCompressed / 1024) + " KB");
            System.out.println("Est. Uncompressed Size:  " + (totalUncompressed / 1024) + " KB");

            if (totalUncompressed > MAX_SAFE_SIZE) {
                System.out.println("❌ DANGER: Total unzipped size exceeds safety limit (1GB)!");
                isBomb = true;
            }

            if (isBomb) {
                System.out.println("Result: 💣 ZIP BOMB DETECTED! Do not extract this file.");
            } else {
                System.out.println("Result: ✅ File appears safe.");
            }
        }
    }
}