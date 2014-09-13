package ie.computing.dcu.kehoea8;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 25/11/2013
 * Time: 18:32
 */

public interface Person {
    public int getHeartRate();
    public int getAge();
    public int getCoreTemperature();

    public void addMedicine(Prescription product);
    public List getMedicine();
}
