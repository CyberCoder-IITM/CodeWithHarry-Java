import java.util.Base64;
import java.util.Scanner;

public class Base64Tool {

    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            return;
        }

        String mode = args[0];
        
        // Combine all remaining arguments into a single string
        StringBuilder inputText = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            inputText.append(args[i]);
            if (i < args.length - 1) {
                inputText.append(" "); // Add space between args
            }
        }
        
        String data = inputText.toString();

        if (data.isEmpty()) {
            System.err.println("Error: No input string provided.");
            printUsage();
            return;
        }

        try {
            if (mode.equalsIgnoreCase("encode")) {
                String encodedString = encode(data);
                System.out.println("Input:    " + data);
                System.out.println("Encoded:  " + encodedString);
                
            } else if (mode.equalsIgnoreCase("decode")) {
                String decodedString = decode(data);
                System.out.println("Input:    " + data);
                System.out.println("Decoded:  " + decodedString);
                
            } else {
                System.err.println("Error: Unknown mode '" + mode + "'");
                printUsage();
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            if (e instanceof IllegalArgumentException) {
                System.err.println("Hint: Your input string might not be valid Base64.");
            }
        }
    }

    /**
     * Encodes a plain text string into a Base64 string.
     */
    public static String encode(String plainText) {
        // Get the bytes from the string and encode them
        byte[] encodedBytes = Base64.getEncoder().encode(plainText.getBytes());
        return new String(encodedBytes);
    }

    /**
     * Decodes a Base64 string back into a plain text string.
     */
    public static String decode(String base64String) {
        // Get the bytes from the Base64 string and decode them
        byte[] decodedBytes = Base64.getDecoder().decode(base64String.getBytes());
        return new String(decodedBytes);
    }

    /**
     * Prints the command-line usage instructions.
     */
    private static void printUsage() {
        System.out.println("Usage:");
        System.out.println("  java Base64Tool encode <text to encode>");
        System.out.println("  java Base64Tool decode <base64 string to decode>");
    }
}
