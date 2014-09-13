package ie.computing.dcu.kehoea8.question1;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 20/11/2013
 * Time: 14:28
 */

public class DuckAdapter implements Turkey {
    Duck duck;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        duck.fly();
    }
}
