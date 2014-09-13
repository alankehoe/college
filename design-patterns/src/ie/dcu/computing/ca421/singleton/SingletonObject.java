package ie.dcu.computing.ca421.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 23/10/2013
 * Time: 09:28
 */
public class SingletonObject {

    private static SingletonObject singletonObject = null;

    private SingletonObject() {

    }

    public static SingletonObject getSingletonObject() {
        if (singletonObject == null) {
            // Only return a new object if the singletonObject is null.
            singletonObject = new SingletonObject();
        }
        return singletonObject;
    }

    public void helloWorld() {
        // Simple method to test Singletons instantiation.
        System.out.println("Hello World");
    }
}
