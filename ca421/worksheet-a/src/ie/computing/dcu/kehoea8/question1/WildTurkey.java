package ie.computing.dcu.kehoea8.question1;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 20/11/2013
 * Time: 14:30
 */

public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble...gobble...!!!");
    }

    @Override
    public void fly() {
        System.out.println("I am flying");
    }
}