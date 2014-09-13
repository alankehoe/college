package ie.dcu.computing.chi;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by SuperTime on 18/03/2014.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Uniformly random: " + chiSquaredTest(generateUniformRandoms(), 31));

        System.out.println("Multiplicative random: " + chiSquaredTest(generateMultiplicativeRandoms(), 31));
    }

    private static int[] generateUniformRandoms() {
        int[] uniformRandoms = new int[100];
        Random ran = new Random();

        for (int j = 0; j < uniformRandoms.length; j++) {
            uniformRandoms[j] = ran.nextInt(31);
        }

        return uniformRandoms;
    }

    private static int[] generateMultiplicativeRandoms() {
        MultiplicativeRandom rand = new MultiplicativeRandom();
        int[] multiplicativeRandoms = new int[100];

        for (int i = 0; i < multiplicativeRandoms.length; i++) {
            multiplicativeRandoms[i] = rand.next();
        }

        return multiplicativeRandoms;
    }


    public static boolean chiSquaredTest(int[] randomNums, int r) {
        //PART A: Get frequency of randoms
        Map<Integer, Integer> ht = getFrequencies(randomNums);

        //PART B: Calculate chi-square - this approach is in Sedgewick
        double n_r = randomNums.length / r;
        double chiSquare = 0;

        for (int v : ht.values()) {
            double f = v - n_r;
            chiSquare += f * f;
        }

        //PART C: According to Sedgewick: "The statistic should be within 2(r)^1/2 of r
        //This is valid if N is greater than about 10r"
        System.out.println("Absolute Number Of Chi-Sqaure: " + Math.abs(chiSquare));
        return Math.abs(chiSquare) <= 2 * Math.sqrt(r);
    }

    
        //@return a Map, key being the number and value its frequency
         private static Map<Integer, Integer> getFrequencies(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<Integer, Integer>();

        for (int x : nums) {
            if (freqs.containsKey(x))
                freqs.put(x, freqs.get(x) + 1);
            else
                freqs.put(x, 1);
        }

        return freqs;
    }
}
