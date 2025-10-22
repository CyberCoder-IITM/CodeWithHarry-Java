import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class AESCryptoDemo {

    // Generate a new AES key
    public static SecretKey generateKey(int n) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(n); // key size: 128, 192, or 256
        return keyGen.generateKey();
    }

    // Encrypt a plaintext string
    public static String encrypt(String plaintext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypt a ciphertext string
    public static String decrypt(String ciphertext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(ciphertext);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
            // Generate AES key
            SecretKey key = generateKey(128);
            System.out.println("Generated Key: " + Base64.getEncoder().encodeToString(key.getEncoded()));

            String message = "This is a top-secret message!";
            System.out.println("Original Message: " + message);

            // Encrypt the message
            String encrypted = encrypt(message, key);
            System.out.println("Encrypted Message: " + encrypted);

            // Decrypt the message
            String decrypted = decrypt(encrypted, key);
            System.out.println("Decrypted Message: " + decrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
