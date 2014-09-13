package ie.dcu.computing.ca421.decorator;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 22/10/2013
 * Time: 16:32
 */
public class Main {
    public static void main(String[] args) {
        Car basicCar = new BasicCar();
        System.out.println("The price of a basic car is €" + basicCar.price());

        Car paintedCar = new ColourDecorator(new BasicCar());
        System.out.println("The price of a car with paint is €" + paintedCar.price());

        Car carWithAlloys = new AlloyDecorator(new BasicCar());
        System.out.println("The price of a car with alloys is €" + carWithAlloys.price());

        Car carWithAllModifications = new AlloyDecorator(new ColourDecorator(new BasicCar()));
        System.out.println("The price of a car with alloys and paint is €" + carWithAllModifications.price());
    }
}
