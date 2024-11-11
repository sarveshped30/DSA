package org.example.dsa;
import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class AsymmetricEncryption {
    // Encrypt using RSA algorithm
    public static String encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypt using RSA algorithm
    public static String decrypt(String encryptedText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    // Generate RSA public/private key pair
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048); // RSA key size (2048-bit)
        return keyGen.generateKeyPair();
    }

    public static void main(String[] args) throws Exception {
        String plainText = "Hello, World!";
        KeyPair keyPair = generateKeyPair();

        String encryptedText = encrypt(plainText, keyPair.getPublic());
        System.out.println("Encrypted Text: " + encryptedText);

        String decryptedText = decrypt(encryptedText, keyPair.getPrivate());
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
