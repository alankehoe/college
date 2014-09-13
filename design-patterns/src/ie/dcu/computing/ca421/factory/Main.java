package ie.dcu.computing.ca421.factory;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 22/10/2013
 * Time: 09:43
 */
public class Main {
    public static void main(String [] args) {
        CarFactory factory = new CarFactory();

        Car first = factory.getCar("Toyota");
        Car second = factory.getCar("Ferrari");

        System.out.println("First car type is: " + first.carType());
        System.out.println("Second car type is: " + second.carType());
    }
}
