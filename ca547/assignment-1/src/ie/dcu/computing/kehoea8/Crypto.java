package ie.dcu.computing.kehoea8;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * Created with IntelliJ IDEA.
 * User: Alan Kehoe
 * Date: 08/11/2013
 * Time: 16:32
 */

public class Crypto {

    private final byte[] salt = generateSalt();
    private final byte[] IV = generateSalt();

    private static Crypto cryptoInstance;

    private Crypto() {
    }

    public static Crypto getInstance() {
        if (cryptoInstance == null) {
            cryptoInstance = new Crypto();
        }
        return cryptoInstance;
    }

    public byte[] getSalt() {
        return salt;
    }

    public byte[] getIV() {
        return IV;
    }

    private SecretKeySpec getAesKey(byte[] encryptionKey) {
        return new SecretKeySpec(encryptionKey, "AES");
    }

    public String byteArrayToHexString(byte[] bytes) {
        return Hex.encodeHexString(bytes);
    }

    public byte[] hexStringToByteArray(String hex) throws DecoderException {
        return Hex.decodeHex(hex.toCharArray());
    }

    private byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private void renameFile(File oldFile, String newName) {
        File newFile = new File(newName);
        if (oldFile.renameTo(newFile)) {
            System.out.println("Success");
        } else {
            System.out.println("Failed to rename file " + oldFile.getName() + " back to " + newFile.getName());
            System.out.println("Your encrypted file is called " + oldFile.getName());
        }
    }

    private byte[] concatenateByteArray(byte[] a, byte[] b) throws IOException {
        ByteArrayOutputStream outputStream;
        outputStream = new ByteArrayOutputStream( );
        outputStream.write(a);
        outputStream.write(b);
        return outputStream.toByteArray( );
    }

    /**
     * Using right to left binary method.
     * http://en.wikipedia.org/w/index.php?title=Modular_exponentiation&oldid=517653653#Right-to-left_binary_method
     */
    public String encryptPassword(String password) throws UnsupportedEncodingException {
        BigInteger bigIntegerPassword = new BigInteger(password.getBytes("UTF-8"));
        BigInteger modulus = Properties.getModulus();
        BigInteger exponent = Properties.getExponent();

        BigInteger result = BigInteger.ONE;
        while (exponent.compareTo(BigInteger.ZERO) > 0) {
            if (exponent.testBit(0))
                result = (result.multiply(bigIntegerPassword)).mod(modulus);
            exponent = exponent.shiftRight(1);
            bigIntegerPassword = (bigIntegerPassword.multiply(bigIntegerPassword)).mod(modulus);
        }
        return result.mod(modulus).toString(16);
    }

    public byte[] hashWithSHA_256(String password, byte[] salt) throws IOException, NoSuchAlgorithmException {
        byte[] saltAndPepper = concatenateByteArray(password.getBytes("UTF-8"), salt);

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(saltAndPepper);

        byte[] md = messageDigest.digest();
        for (int i = 0; i < 200; i++) {
            messageDigest.update(md);
            md = messageDigest.digest();
        }
        return md;
    }

    public void encryptFileWithAes(byte[] encryptionKey, byte[] IV, String fileName) {
        try {
            File encryptedFile = new File("Encrypted_" + fileName);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
            cipher.init(Cipher.ENCRYPT_MODE, getAesKey(encryptionKey), new IvParameterSpec(IV));

            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);

                // Write to the Encrypted file
                FileOutputStream outputStream = new FileOutputStream(encryptedFile);
                byte[] b = new byte[8];
                int i = cipherInputStream.read(b);
                while (i != -1) {
                    outputStream.write(b, 0, i);
                    i = cipherInputStream.read(b);
                }
                outputStream.flush();
                outputStream.close();
                cipherInputStream.close();
                inputStream.close();
                renameFile(encryptedFile, fileName);
            } catch (IOException err) {
                System.out.println("Cannot open file!");
                err.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void decryptFileWithAes(byte[] encryptionKey, byte[] IV, String fileName) {
        try {
            File encryptedFile = new File(fileName);
            if (!encryptedFile.exists()) {
                System.out.println("The file specified does not exist");
                System.exit(-1);
            }

            File plainTextFile = new File("Decrypted_" + fileName);

            Cipher decrypt = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
            decrypt.init(Cipher.DECRYPT_MODE, getAesKey(encryptionKey), new IvParameterSpec(IV));

            FileInputStream fileInputStream = new FileInputStream(encryptedFile);
            CipherInputStream cipherInputStream = new CipherInputStream(fileInputStream, decrypt);

            FileOutputStream fileOutputStream = new FileOutputStream(plainTextFile);
            byte[] b = new byte[8];
            int i = cipherInputStream.read(b);
            while (i != -1) {
                fileOutputStream.write(b, 0, i);
                i = cipherInputStream.read(b);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            cipherInputStream.close();
            fileInputStream.close();

            renameFile(plainTextFile, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}