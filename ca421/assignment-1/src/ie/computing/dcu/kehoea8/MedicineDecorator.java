package ie.computing.dcu.kehoea8;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */

public abstract class MedicineDecorator implements Prescription {
    public Prescription prescription;

    // takes a Prescription object in the constructor
    public MedicineDecorator(Prescription prescription) {
        this.prescription = prescription;
    }

    // Override interface methods
    @Override
    public float getPrice(){
        return prescription.getPrice();
    }

    @Override
    public  String getName() {
        return prescription.getName();
    }
}
