import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * PixelVault - A simple LSB (Least Significant Bit) Steganography tool.
 * * CONCEPT:
 * This program hides a secret text message inside the Blue component of 
 * an image's pixels. It uses the last bit (LSB) to store data, ensuring 
 * the visual change is imperceptible to the human eye.
 */
public class PixelVault {

    // Delimiter to mark the end of our message so we know when to stop reading bits
    private static final String END_MARKER = "%%EOF%%";

    public static void main(String[] args) {
        try {
            // 1. Define your source image and output destination
            // NOTE: Use a PNG or BMP (lossless). JPEG compression destroys LSB data.
            File sourceImage = new File("original.png"); 
            File outputImage = new File("secret.png");
            
            // 2. The secret data you want to hide
            // (Nod to your interests: maybe a secret recipe or a gym PR?)
            String secretMessage = "Operation Bombay Duck is a go. Target confirmed.";

            // --- ENCODING ---
            System.out.println("Encrypting message...");
            hideMessage(sourceImage, outputImage, secretMessage);
            System.out.println("Success! Secret hidden in " + outputImage.getName());

            // --- DECODING ---
            System.out.println("Decrypting message from image...");
            String revealed = revealMessage(outputImage);
            System.out.println("Revealed Secret: " + revealed);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Hides the message string inside the source image and saves to output.
     */
    public static void hideMessage(File src, File dest, String message) throws IOException {
        BufferedImage image = ImageIO.read(src);
        String fullMessage = message + END_MARKER;
        
        // Convert message to a queue of bits for easy processing
        String binaryMessage = stringToBinary(fullMessage);
        
        int width = image.getWidth();
        int height = image.getHeight();
        int msgIndex = 0;

        // Iterate over pixels to hide bits
        outerLoop:
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (msgIndex >= binaryMessage.length()) {
                    break outerLoop;
                }

                // Get current pixel color
                int rgb = image.getRGB(x, y);
                
                // Extract the bit we want to hide ('0' or '1')
                int bitToHide = binaryMessage.charAt(msgIndex) - '0';

                // Modify the Blue component using bitwise manipulation
                // 0xFFFFFFFE masks out the last bit (sets it to 0)
                // | bitToHide sets the last bit to our data
                int newRgb = (rgb & 0xFFFFFFFE) | bitToHide;

                image.setRGB(x, y, newRgb);
                msgIndex++;
            }
        }
        
        ImageIO.write(image, "png", dest);
    }

    /**
     * Extracts the hidden message from the image.
     */
    public static String revealMessage(File src) throws IOException {
        BufferedImage image = ImageIO.read(src);
        StringBuilder extractedBinary = new StringBuilder();
        
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                
                // Extract the LSB (Least Significant Bit)
                // (rgb & 1) gives us the last bit
                int lsb = rgb & 1;
                extractedBinary.append(lsb);
            }
        }

        // Convert binary stream back to text and look for our EOF marker
        return binaryToString(extractedBinary.toString());
    }

    // --- HELPER METHODS ---

    private static String stringToBinary(String message) {
        StringBuilder binary = new StringBuilder();
        for (char c : message.toCharArray()) {
            // Format each char as an 8-bit binary string
            binary.append(String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0'));
        }
        return binary.toString();
    }

    private static String binaryToString(String binary) {
        StringBuilder message = new StringBuilder();
        
        // Process 8 bits at a time (1 byte = 1 char)
        for (int i = 0; i + 8 <= binary.length(); i += 8) {
            String byteStr = binary.substring(i, i + 8);
            int charCode = Integer.parseInt(byteStr, 2);
            char c = (char) charCode;
            message.append(c);
            
            // Check if we hit the end marker
            if (message.toString().endsWith(END_MARKER)) {
                return message.substring(0, message.length() - END_MARKER.length());
            }
        }
        return message.toString();
    }
}