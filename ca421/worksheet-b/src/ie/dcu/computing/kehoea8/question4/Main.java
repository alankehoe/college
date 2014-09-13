package ie.dcu.computing.kehoea8.question4;

import ie.dcu.computing.kehoea8.question1.BasicSingleton;
import ie.dcu.computing.kehoea8.question3.SynchronizedSingleton;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */

public class Main {
    public static void main(String[] args) {
//        Timing tests
        SynchronizedSingleton.getInstance();
        BasicSingleton.getInstance();
        LockingSingleton.getInstance();

        System.out.println("Basic Singleton takes " + BasicSingleton.getTime());
        System.out.println("Synchronized Singleton takes " + SynchronizedSingleton.getTime());
        System.out.println("locking Singleton takes " + LockingSingleton.getTime() + "\n");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000000; i++) {
                    LockingSingleton.getInstance();
                }
            }
        };

        Thread one = new Thread(runnable);
        Thread two = new Thread(runnable);

        one.start();
        two.start();

        System.out.println("Amount of times singleton was created by threads: " + LockingSingleton.getCounter());
    }
}
