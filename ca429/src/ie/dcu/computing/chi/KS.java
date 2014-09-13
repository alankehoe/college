package ie.dcu.computing.chi;

import java.io.*;
import java.util.Random;


class KSTest {

    void ktest(double num[], double critNumber) {


        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    double temp;
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        //Create varaibles for our one-sided statistics
        double d1[] = new double[num.length];
        double d2[] = new double[num.length];
        double n = (double) num.length;


//      The "one-sided" statistics are:
//        Dn+ = MAX( S(x[j]) - F(x[j]) )
//                = MAX( ((j+1)/n) - F(x[j]) )
//        Dn- = MAX( F(x[j]) - S(x[j]) )
//                = MAX( F(x[j]) - (j/n) )


        for (int i = 0; i < num.length; i++) {
            d1[i] = ((i + 1) / n) - num[i];
        }

        for (int i = 0; i < num.length; i++) {
            d2[i] = (num[i] - (i) / n);
        }

        double d1max = d1[0];
        for (int i = 0; i < num.length; i++) {
            if (d1max <= d1[i]) {
                d1max = d1[i];
            }
        }

        System.out.println("D+ = " + d1max);

        double d2max = d2[0];
        for (int i = 0; i < num.length; i++) {
            if (d2max <= d2[i]) {
                d2max = d2[i];
            }
        }

        System.out.println("D- = " + d2max);

        double dplus = d1max;
        double dminus = d2max;
        double d;

        if (dplus > dminus) {
            d = dplus;
            System.out.println("D = " + d);
        } else {
            d = dminus;
            System.out.println("D = " + d);
        }

        if (d < critNumber) {
            System.out.println("Uniformity Of Sample Accepted");
        } else {
            System.out.println("Uniformity Of Sample Rejected");
        }

    }
}

public class KS {


    public static void main(String[] args) throws IOException {



      double a[] = generateUniformRandoms();
      double b[] = generateMultiplicativeRandoms();



     for (int i = 0; i < 100; i++) {
            a[i] = generateUniformRandoms()[i];
            b[i] = generateMultiplicativeRandoms()[i];
     }

        double da = 10;


        KSTest kst1 = new KSTest();
        System.out.println("Uniform Random Testing Via KS, Crticial Number = " + da);
        kst1.ktest(a, da);


        KSTest kst2 = new KSTest();
        System.out.println("MC Method Testing Via KS, Crticial Number = " + da);
        kst2.ktest(b, da);

    }

    private static double[] generateUniformRandoms() {
        double[] uniformRandoms = new double[100];
        Random ran = new Random();

        for (int j = 0; j < uniformRandoms.length; j++) {
            uniformRandoms[j] = ran.nextInt(31);
        }

        return uniformRandoms;
    }

    private static double[] generateMultiplicativeRandoms() {
        MultiplicativeRandom rand = new MultiplicativeRandom();
        double[] multiplicativeRandoms = new double[100];

        for (int i = 0; i < multiplicativeRandoms.length; i++) {
            multiplicativeRandoms[i] = rand.next();
        }

        return multiplicativeRandoms;
    }
 }