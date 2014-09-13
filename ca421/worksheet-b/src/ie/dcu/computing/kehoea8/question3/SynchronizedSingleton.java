package ie.dcu.computing.kehoea8.question3;

/**
 * Created by Alan Kehoe on 17/12/2013.
 */

public class SynchronizedSingleton {
    private static SynchronizedSingleton instance = null;
    private static int counter = 0;
    private static long time;

    private SynchronizedSingleton() {
    }

    public static synchronized SynchronizedSingleton getInstance() {
        long start = System.nanoTime();
        if (instance == null) {
            instance = new SynchronizedSingleton();
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
