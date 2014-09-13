package ie.computing.dcu.kehoea8.question6;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 21/11/2013
 * Time: 18:10
 */

public class GoodbyeThread extends Thread {
    private final String goodbye = "goodbye";

    @Override
    public synchronized void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println(goodbye);
        }
    }
}
