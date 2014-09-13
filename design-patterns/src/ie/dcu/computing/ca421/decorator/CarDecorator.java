package ie.dcu.computing.ca421.decorator;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 23/10/2013
 * Time: 09:03
 */
public abstract class CarDecorator implements Car {

    protected Car modifiedCar;

    public CarDecorator( Car modifiedCar) {
        this.modifiedCar = modifiedCar;
    }

    public int price() {
        return modifiedCar.price();
    }

}
