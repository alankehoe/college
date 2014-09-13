package ie.dcu.computing.kehoea8.question1;

/**
 * Created by Alan Kehoe on 17/12/2013.
 */

public class BasicSingleton {
    private static BasicSingleton instance = null;
    private static int counter = 0;
    private static long time;

    private BasicSingleton() {
    }

    public static BasicSingleton getInstance() {
        long start = System.nanoTime();
        if (instance == null) {
            instance = new BasicSingleton();
            counter++;
        }
        long end = System.nanoTime();
        time = end - start;
        return instance;
    }

    public static int getCounter() {
        return counter;
    }

    public static long getTime() {
        return time;
    }
}
