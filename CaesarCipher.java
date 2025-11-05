import java.util.Scanner;

/**
 * A single-file Java program that can encrypt or decrypt text
 * using the Caesar Cipher algorithm.
 * * This program demonstrates string manipulation, character arithmetic,
 * user input handling with validation, and a clear method structure.
 */
public class CaesarCipher {

    /**
     * The main method runs the user menu and application loop.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("Welcome to the Caesar Cipher Program!");

        while (isRunning) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Encrypt a message");
            System.out.println("2. Decrypt a message");
            System.out.println("3. Exit");
            System.out.print("Please enter your choice (1-3): ");

            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    // Get text and shift key from user, then encrypt
                    System.out.print("Enter the message to encrypt: ");
                    String textToEncrypt = scanner.nextLine();
                    int encryptKey = getShiftKey(scanner);
                    String encryptedText = cipher(textToEncrypt, encryptKey);
                    System.out.println("Encrypted message: " + encryptedText);
                    break;
                case 2:
                    // Get text and shift key from user, then decrypt
                    System.out.print("Enter the message to decrypt: ");
                    String textToDecrypt = scanner.nextLine();
                    int decryptKey = getShiftKey(scanner);
                    // Decryption is just encryption with a negative key
                    String decryptedText = cipher(textToDecrypt, -decryptKey);
                    System.out.println("Decrypted message: " + decryptedText);
                    break;
                case 3:
                    // Exit the loop
                    isRunning = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
        
        scanner.close();
    }

    /**
     * Encrypts or decrypts a string by shifting its letters.
     *
     * @param text  The input string to process.
     * @param shift The number of positions to shift each letter.
     * (Positive for encryption, negative for decryption).
     * @return The resulting processed string.
     */
    public static String cipher(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            // Check if the character is a letter
            if (Character.isLetter(c)) {
                // Determine if it's upper or lower case to find the correct base
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                
                // --- The Core Logic ---
                // 1. (c - base): Get the 0-25 index of the letter (e.g., 'c' - 'a' = 2)
                // 2. (+ shift): Apply the shift (e.g., 2 + 3 = 5)
                // 3. (% 26): Use modulo to wrap around the alphabet (e.g., 25 + 2 = 27 -> 27 % 26 = 1)
                // 4. (+ 26) % 26: A trick to handle negative shifts correctly (e.g., 2 - 3 = -1 -> (-1 + 26) % 26 = 25)
                // 5. (+ base): Convert the 0-25 index back to the ASCII character
                
                int newPosition = (c - base + shift) % 26;
                if (newPosition < 0) {
                    newPosition += 26; // Handle negative shifts
                }
                
                char shiftedChar = (char) (base + newPosition);
                result.append(shiftedChar);
            } else {
                // If it's not a letter (like ' ', '!', '1'), leave it unchanged
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * Safely gets a menu choice (1-3) from the user.
     */
    private static int getUserChoice(Scanner scanner) {
        while (true) {
            try {
                // Read the whole line and parse it
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 3) {
                    return choice;
                } else {
                    System.out.print("Invalid choice. Please enter 1, 2, or 3: ");
                }
            } catch (NumberFormatException e) {
                // This catches non-numeric input
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    /**
     * Safely gets the cipher shift key (1-25) from the user.
     */
    private static int getShiftKey(Scanner scanner) {
        while (true) {
            System.out.print("Enter the shift key (a number from 1 to 25): ");
            try {
                int key = Integer.parseInt(scanner.nextLine());
                if (key >= 1 && key <= 25) {
                    return key;
                } else {
                    System.out.println("Key must be between 1 and 25.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}