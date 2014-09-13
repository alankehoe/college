package ie.dcu.computing.kehoea8.question1;

/**
 * Created by Alan Kehoe on 17/12/2013.
 */

public class Main {
    public static void main(String[] args) {
        BasicSingleton basicSingleton;
        for (int i = 0; i < 10000000; i++) {
            basicSingleton = BasicSingleton.getInstance();
            System.out.println(basicSingleton.getCounter());
        }
    }
}
