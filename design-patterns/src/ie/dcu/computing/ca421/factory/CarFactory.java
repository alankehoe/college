package ie.dcu.computing.ca421.factory;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 22/10/2013
 * Time: 08:51
 */
public class CarFactory {
    protected Car getCar(String make) {
        if (make.equals("Toyota")) {
            return new Toyota();
        } else {
            // If the car is not a Toyota then it must be a Ferrari.
            return new Ferrari();
        }
    }
}
