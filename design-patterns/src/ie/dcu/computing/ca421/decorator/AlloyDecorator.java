package ie.dcu.computing.ca421.decorator;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 23/10/2013
 * Time: 09:07
 */
public class AlloyDecorator extends CarDecorator {

    private int alloyPrice = 1000;

    public AlloyDecorator(Car modifiedCar) {
        super(modifiedCar);
    }

    public int price(){
        return modifiedCar.price() + alloyPrice;
    }
}
