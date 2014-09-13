package ie.dcu.computing.kehoea8;

/**
 * Created with IntelliJ IDEA.
 * User: Alan Kehoe
 * Date: 03/11/2013
 * Time: 22:08
 */

public class Main {

    public static void main(String [] args) throws Exception {
        Crypto crypto = Crypto.getInstance();

        if (args.length == 2) {
            String password = args[0];
            byte[] salt = crypto.getSalt();
            byte[] IV = crypto.getIV();
            byte[] aesKey = crypto.hashWithSHA_256(password, salt);
            String fileName = args[1];

            System.out.println("Encrypting file: " + fileName + "\n");

            System.out.println("Using password: " + password);
            System.out.println("Encrypted password: " + crypto.encryptPassword(password) + "\n");
            System.out.println("Using " + salt.length * 8 + " bit salt : " + crypto.byteArrayToHexString(salt));
            System.out.println("Using " + IV.length * 8 + " bit IV : " + crypto.byteArrayToHexString(IV) + "\n");

            crypto.encryptFileWithAes(aesKey, IV, fileName);
        } else if (args.length == 4) {
            String password = args[0];
            byte[] salt = crypto.hexStringToByteArray(args[1]);
            byte[] vector = crypto.hexStringToByteArray(args[2]);
            String file = args[3];
            byte[] aesKey = crypto.hashWithSHA_256(password, salt);

            System.out.println("Decrypting file: " + file + "\n");

            System.out.println("Using password: " + password);
            System.out.println("Using " + salt.length * 8 + " bit Salt : " + crypto.byteArrayToHexString(salt));
            System.out.println("Using " + vector.length * 8 + " bit IV : " + crypto.byteArrayToHexString(vector));
            System.out.println("Using " + aesKey.length * 8 + " bit AES KEY: " + crypto.byteArrayToHexString(aesKey) + "\n");

            crypto.decryptFileWithAes(aesKey, vector, file);
        } else {
            System.out.println("Usage : java -jar assignment-1.jar <password> <filename>");
            System.out.println("Usage : java -jar assignment-1.jar <password> <salt> <iv> <filename>");
        }
    }
}
