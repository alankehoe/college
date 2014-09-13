package ie.dcu.computing.ca421.decorator;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 23/10/2013
 * Time: 09:10
 */
public class ColourDecorator extends CarDecorator {

    private int paintPrice = 5000;

    public ColourDecorator(Car modifiedCar) {
        super(modifiedCar);
    }

    public int price() {
        return modifiedCar.price() + paintPrice;
    }
}
