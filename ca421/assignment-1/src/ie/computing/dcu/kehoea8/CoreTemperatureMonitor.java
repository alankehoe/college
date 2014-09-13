package ie.computing.dcu.kehoea8;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 25/11/2013
 * Time: 18:55
 */

public class CoreTemperatureMonitor implements Monitor {
    Patient patient;

    // Instantiate the patient in the constructor
    public CoreTemperatureMonitor(Patient patient) {
        this.patient = patient;
        // Attach self to the patient
        this.patient.attachMonitor(this);
    }

    // Override Monitor interface
    @Override
    public void update() {
        int coreTemperature = patient.getCoreTemperature();

        // Check to see if the patient is ok and prescribe medicine if not
        if (coreTemperature > 40) {
            patient.addMedicine(new BodyTemperatureMedicine(new Medicine()));
        } else if (coreTemperature < 35) {
            patient.addMedicine(new BodyTemperatureMedicine(new Medicine()));
        }
    }
}
