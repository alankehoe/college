package ie.computing.dcu.kehoea8.question1;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 25/11/2013
 * Time: 10:39
 */

public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack Quack");
    }

    @Override
    public void fly() {
        System.out.println("I am flying");
    }
}
