package ie.computing.dcu.kehoea8.question1;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 19/11/2013
 * Time: 18:30
 */

public class Main {
    public static void main(String[] args) {
        MallardDuck mallardDuck = new MallardDuck();
        DuckAdapter duckAdapter = new DuckAdapter(mallardDuck);

        duckAdapter.gobble();
        duckAdapter.fly();
    }
}