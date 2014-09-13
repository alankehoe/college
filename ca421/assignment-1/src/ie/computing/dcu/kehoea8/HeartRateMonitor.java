package ie.computing.dcu.kehoea8;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 25/11/2013
 * Time: 18:55
 */

public class HeartRateMonitor implements Monitor {
    Patient patient;

    // Instantiate the patient in the constructor
    public HeartRateMonitor(Patient patient) {
        this.patient = patient;
        // Attach self to the patient
        this.patient.attachMonitor(this);
    }

    // Override Monitor interface
    @Override
    public void update() {
        int age = patient.getAge();
        int heartRate = patient.getHeartRate();

        // Check to see if the patient is ok and prescribe medicine if not
        if (heartRate > 220 - age) {
            patient.addMedicine(new HeartRateMedicine(new Medicine()));
        } else if (heartRate < 45 && heartRate > 0) {
            patient.addMedicine(new HeartRateMedicine(new Medicine()));
        }
    }
}
