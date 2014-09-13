package ie.computing.dcu.kehoea8;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */

public class HeartRateMedicine extends MedicineDecorator {
    // Inherit from MedicineDecorator Abstract class
    public HeartRateMedicine(Prescription prescription) {
        super(prescription);
    }

    // Override methods in MedicineDecorator
    @Override
    public float getPrice() {
        float price = (float) 58.76;
        return prescription.getPrice() + price;
    }

    @Override
    public String getName() {
        String name = " Heart Medicine,";
        return prescription.getName().concat(name);
    }
}
