import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileHasher {

    public static void main(String[] args) {
        // Check if the user has provided the correct number of arguments
        if (args.length != 2) {
            System.err.println("Usage: java FileHasher <Algorithm> <FilePath>");
            System.err.println("Example: java FileHasher SHA-256 /path/to/your/file.txt");
            System.exit(1);
        }

        String algorithm = args[0];
        String filePath = args[1];

        try {
            // Get an instance of the specified hashing algorithm
            MessageDigest md = MessageDigest.getInstance(algorithm);

            // Read the file and update the message digest
            try (FileInputStream fis = new FileInputStream(filePath)) {
                byte[] byteArray = new byte[1024];
                int bytesCount = 0;
                while ((bytesCount = fis.read(byteArray)) != -1) {
                    md.update(byteArray, 0, bytesCount);
                }
            }

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // Convert byte array to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Print the final hash
            System.out.println("File: " + filePath);
            System.out.println("Algorithm: " + algorithm);
            System.out.println("Hash: " + sb.toString());

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: Algorithm '" + algorithm + "' not recognized.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Error: Could not read file '" + filePath + "'.");
            System.exit(1);
        }
    }
}