package ie.dcu.computing.kehoea8;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 29/11/2013
 * Time: 11:16
 */

public class Cryptography {
    private final Random random;

    private final BigInteger p;
    private final BigInteger g;
    private final BigInteger x;
    private final BigInteger y;
    private final BigInteger k;
    private final BigInteger r;
    private final BigInteger s;
    private final byte[] m;
    private final BigInteger ZERO = new BigInteger("0");
    private final BigInteger ONE = new BigInteger("1");

    public Cryptography(String fileName) throws IOException, NoSuchAlgorithmException {
        this.random = new Random();

        this.p = Properties.getPrimeModulus();
        this.g = Properties.getGenerator();
        this.x = generateX();
        this.y = generateY();
        this.k = generateK();
        this.r = generateR();
        this.m = zipToBytes(fileName);
        this.s = generateS();
    }

    public BigInteger getY() {
        return y;
    }

    public BigInteger getR() {
        return r;
    }

    public BigInteger getS() {
        return s;
    }

    public BigInteger getK() {
        return k;
    }

    public BigInteger getP() {
        return p;
    }

    private BigInteger generateHash() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(m);
        return new BigInteger(hash);
    }

    private BigInteger[] extendedEuclidean(BigInteger p, BigInteger q) {
        if (q.equals(ZERO))
            return new BigInteger[]{p, ONE, ZERO};

        BigInteger[] values = extendedEuclidean(q, p.mod(q));
        BigInteger d = values[0];
        BigInteger a = values[2];
        BigInteger b = values[1].subtract((p.divide(q)).multiply(values[2]));
        return new BigInteger[]{d, a, b};
    }

    public BigInteger multiplicativeInverse(BigInteger p, BigInteger q) {
        return extendedEuclidean(p, q)[1].mod(q);
    }

    private BigInteger generateS() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        BigInteger bigInteger = (generateHash().subtract(x.multiply(r)));
        bigInteger = bigInteger.multiply(multiplicativeInverse(k, p.subtract(ONE)));
        return bigInteger.mod(p.subtract(ONE));
    }

    private BigInteger generateR() {
        return g.modPow(k, p);
    }

    private BigInteger generateX() {
        int maxNumBitLength = p.bitLength();

        BigInteger randomValue = new BigInteger(maxNumBitLength, random);
        while (randomValue.compareTo(p) == 1) {
            randomValue = new BigInteger(maxNumBitLength, random);
        }

        return randomValue;
    }

    private BigInteger generateK() {
        BigInteger k = new BigInteger(1024, 1, random);
        while (k.compareTo(p) == 1) {
            k = new BigInteger(1024, 1, random);
        }
        return k;
    }

    private BigInteger generateY() {
        return g.modPow(x, p);
    }

    private byte[] zipToBytes(String fileName) throws IOException {
        FileInputStream fileInputStream;
        File file = new File(fileName);
        byte[] bytes = new byte[(int) file.length()];

        fileInputStream = new FileInputStream(fileName);
        int status = fileInputStream.read(bytes);
        if (status == 1) {
            fileInputStream.close();
        }
        return bytes;
    }

    // Verification method.
    public boolean verifyMessage() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        BigInteger leftSide = g.modPow(generateHash(), p);
        BigInteger rightSide = y.modPow(r, p).multiply(r.modPow(s, p)).mod(p);
        return leftSide.equals(rightSide);
    }
}
