package ie.computing.dcu.kehoea8;

import static java.lang.Thread.sleep;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 25/11/2013
 * Time: 18:02
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Instantiate a new patient.
        Patient patient = Patient.getInstance("Alan", "Kehoe", 23);
        float medicalBill = (float) 0.0;

        // Assign the two monitor's
        HeartRateMonitor heartRateMonitor = new HeartRateMonitor(patient);
        CoreTemperatureMonitor coreTemperatureMonitor = new CoreTemperatureMonitor(patient);

        // Simulate a patient being monitored for 20 seconds. Notifying monitors every 2 seconds
        for (int i = 0; i < 10; i++) {
            patient.notifyMonitors();
            sleep(2000);
        }

        // Print out all applied medicines and calculate bill.
        for (Prescription prescription : patient.getMedicine()) {
            medicalBill += prescription.getPrice();
            System.out.println("Medicine Name = " + prescription.getName());
        }

        // Detach the monitors the patient is finished here
        patient.detatchMonitor(heartRateMonitor);
        patient.detatchMonitor(coreTemperatureMonitor);

        System.out.println("Amount of monitors still attached " + patient.getMonitors().size());
        System.out.println("Total medical bill " + medicalBill);
    }
}
