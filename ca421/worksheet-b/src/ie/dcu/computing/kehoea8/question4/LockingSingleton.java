package ie.dcu.computing.kehoea8.question4;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */

public class LockingSingleton {
    private static volatile LockingSingleton instance;
    private static boolean initialized = false;
    private static int counter = 0;
    private static long time;

    private LockingSingleton() {
    }

    public static LockingSingleton getInstance() {
        long start = System.nanoTime();
        if (!initialized) {
            synchronized (LockingSingleton.class) {
                if (!initialized) {
                    instance = new LockingSingleton();
                    initialized = true;
                    counter++;
                }
            }
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
