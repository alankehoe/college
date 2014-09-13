package ie.computing.dcu.kehoea8;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 25/11/2013
 * Time: 18:30
 */

public class Medicine implements Prescription {
    // All medicines carry an initial fee of 10.00
    @Override
    public String getName() {
        return "Medicine Fee,";
    }

    @Override
    public float getPrice() {
        return (float) 10.00;
    }
}
