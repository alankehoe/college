package ie.dcu.computing.kehoea8;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Alan Kehoe
 * Date: 15/11/2013
 * Time: 17:34
 */

class Properties {

    private static final String publicModulus = "c406136c12640a665900a9df4df63a84fc8559" +
            "27b729a3a106fb3f379e8e4190ebba442f67b93402e535b18a5777e6490e67dbee95" +
            "4bb02175e43b6481e7563d3f9ff338f07950d1553ee6c343d3f8148f71b4d2df8da7" +
            "efb39f846ac07c865201fbb35ea4d71dc5f858d9d41aaa856d50dc2d2732582f80e7d38c32aba87ba9";
    private static final String publicExponent = "65537";

    public static BigInteger getModulus() {
        return new BigInteger(publicModulus, 16);
    }

    public static BigInteger getExponent() {
        return new BigInteger(publicExponent);
    }
}
