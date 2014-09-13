package ie.computing.dcu.kehoea8.question6;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 21/11/2013
 * Time: 18:10
 */

public class Main {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        GoodbyeThread goodbyeThread = new GoodbyeThread();

        helloThread.start();
        goodbyeThread.start();
    }
}
