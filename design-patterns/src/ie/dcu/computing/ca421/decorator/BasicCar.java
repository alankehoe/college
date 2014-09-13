package ie.dcu.computing.ca421.decorator;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 23/10/2013
 * Time: 09:00
 */
public class BasicCar implements Car {

    @Override
    public int price() {
        return 10000;
    }
}
