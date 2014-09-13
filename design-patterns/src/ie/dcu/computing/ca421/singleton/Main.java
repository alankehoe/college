package ie.dcu.computing.ca421.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 23/10/2013
 * Time: 09:24
 */
public class Main {
    public static void main(String [] args) {
        SingletonObject singletonObject = SingletonObject.getSingletonObject();
        singletonObject.helloWorld();
    }
}
