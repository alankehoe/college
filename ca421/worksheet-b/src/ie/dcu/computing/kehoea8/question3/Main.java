package ie.dcu.computing.kehoea8.question3;

import ie.dcu.computing.kehoea8.question1.BasicSingleton;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */

public class Main {
    public static void main(String[] args) {
        SynchronizedSingleton.getInstance();
        BasicSingleton.getInstance();

        System.out.println("Basic Singleton takes " + BasicSingleton.getTime());
        System.out.println("Synchronized Singleton takes " + SynchronizedSingleton.getTime());
    }
}
