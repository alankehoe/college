package ie.computing.dcu.kehoea8;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */

public class BodyTemperatureMedicine extends MedicineDecorator {
    public BodyTemperatureMedicine(Prescription prescription) {
        // Inherit from MedicineDecorator Abstract class
        super(prescription);
    }

    // Override methods in MedicineDecorator
    @Override
    public float getPrice() {
        float price = (float) 36.23;
        return prescription.getPrice() + price;
    }

    @Override
    public String getName() {
        String name = " Body Temperature,";
        return prescription.getName().concat(name);
    }
}