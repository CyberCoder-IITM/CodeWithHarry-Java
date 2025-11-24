import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * EntropyMeter - A Password Strength Analyzer based on Information Theory.
 * * CONCEPT:
 * Most password checkers just look for regex patterns. This tool calculates 
 * the actual 'Entropy' (randomness) in bits.
 * * FORMULA: Entropy = Length * log2(PoolSize)
 */
public class EntropyMeter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- ENTROPY METER: PASSWORD AUDITOR ---");
        System.out.print("Enter a password to analyze: ");
        String password = scanner.nextLine();

        if (password.isEmpty()) {
            System.out.println("Error: Password cannot be empty.");
            return;
        }

        // 1. Calculate Pool Size (R)
        int poolSize = getPoolSize(password);
        
        // 2. Calculate Entropy (E = L * log2(R))
        double entropy = calculateEntropy(password.length(), poolSize);
        
        // 3. Estimate Crack Time (Assuming 10 billion guesses/second - fast GPU)
        String timeToCrack = estimateCrackTime(entropy);

        // --- REPORT ---
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("\n--- AUDIT RESULTS ---");
        System.out.println("Password Length: " + password.length());
        System.out.println("Character Pool:  " + poolSize + " possible characters");
        System.out.println("Entropy Score:   " + df.format(entropy) + " bits");
        System.out.println("Strength Rating: " + getRating(entropy));
        System.out.println("Est. Crack Time: " + timeToCrack);
        System.out.println("---------------------");
        
        scanner.close();
    }

    /**
     * Determines the size of the character set used.
     * Lowercase=26, Upper=26, Digits=10, Symbols=33 -> Max ~95
     */
    private static int getPoolSize(String pass) {
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSymbol = false;
        
        for (char c : pass.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSymbol = true;
        }

        int pool = 0;
        if (hasLower) pool += 26;
        if (hasUpper) pool += 26;
        if (hasDigit) pool += 10;
        if (hasSymbol) pool += 33; 
        
        return pool == 0 ? 1 : pool; // Prevent log(0)
    }

    /**
     * Calculates Shannon Entropy in bits.
     * Log2(N) = Log(N) / Log(2)
     */
    private static double calculateEntropy(int length, int poolSize) {
        return length * (Math.log(poolSize) / Math.log(2));
    }

    /**
     * Rates the entropy based on industry standards.
     */
    private static String getRating(double entropy) {
        if (entropy < 28) return "Very Weak (Instantly Crackable)";
        if (entropy < 36) return "Weak";
        if (entropy < 60) return "Moderate";
        if (entropy < 127) return "Strong";
        return "Very Strong";
    }

    /**
     * Estimates time to crack assuming a high-end cracking rig 
     * (10^10 guesses per second).
     */
    private static String estimateCrackTime(double entropy) {
        // 2^entropy = total combinations
        double combinations = Math.pow(2, entropy);
        
        // Assume 10 billion guesses per second (High-end GPU array)
        double seconds = combinations / 10_000_000_000L;

        if (seconds < 1) return "Instant";
        if (seconds < 60) return String.format("%.2f seconds", seconds);
        if (seconds < 3600) return String.format("%.2f minutes", seconds / 60);
        if (seconds < 86400) return String.format("%.2f hours", seconds / 3600);
        if (seconds < 31536000) return String.format("%.2f days", seconds / 86400);
        
        return String.format("%.2f years", seconds / 31536000);
    }
}