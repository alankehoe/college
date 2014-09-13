package ie.dcu.computing.kehoea8;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 29/11/2013
 * Time: 11:03
 */

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        if (args.length == 1) {
            Cryptography cryptography = new Cryptography(args[0]);

            System.out.println("Y = " + cryptography.getY().toString(16));
            System.out.println("R = " + cryptography.getR().toString(16));
            System.out.println("S = " + cryptography.getS().toString(16));

            // Verify my method
            System.out.println("Verifying result: " + cryptography.verifyMessage());
        } else {
            System.out.println("Usage : java -jar assignment-2.jar <filename>");
        }
    }
}
