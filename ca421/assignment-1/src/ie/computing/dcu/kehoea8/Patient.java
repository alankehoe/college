package ie.computing.dcu.kehoea8;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 25/11/2013
 * Time: 18:27
 */

public class Patient implements Person {
    private String firstName;
    private String lastName;
    private int age;
    private ArrayList<Prescription> productList;
    private ArrayList<Monitor> attachedMonitors;
    private static Patient instance = null;

    public int heartRate;
    public int coreTemperature;

    // Patients are singletons.
    private Patient(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        this.productList = new ArrayList<Prescription>();
        this.attachedMonitors = new ArrayList<Monitor>();

        // Start simulating the patient when a patient is created.
        PatientEngine patientEngine = new PatientEngine();
        patientEngine.start();
    }

    // this is how to access a patient.
    // method is synchronized for thread safety.
    // in case two people wanted to register a patient in the hospital at the same time.
    public static synchronized Patient getInstance(String firstName, String lastName, int age) {
        if(instance == null) {
            instance = new Patient(firstName, lastName, age);
        }
        return instance;
    }

    // Override Person interface
    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getHeartRate() {
        return heartRate;
    }

    @Override
    public int getCoreTemperature() {
        return coreTemperature;
    }

    @Override
    public void addMedicine(Prescription product) {
        productList.add(product);
    }

    @Override
    public ArrayList<Prescription> getMedicine() {
        return productList;
    }

    public ArrayList<Monitor> getMonitors() {
        return attachedMonitors;
    }

    // Notification to all attached monitors
    public void notifyMonitors() {
        for (Monitor monitor : attachedMonitors) {
            monitor.update();
        }
    }

    // Attaching a monitor to a patient
    public void attachMonitor(Monitor monitor) {
        attachedMonitors.add(monitor);
    }

    // Remove a monitor from a patient
    public void detatchMonitor(Monitor monitor) {
        attachedMonitors.remove(monitor);
    }

    // Simulate a patients vitals with random values
    class PatientEngine extends Thread {
        @Override
        public synchronized void run() {
            while (true) {
                heartRate = randomIntBetween(0, 250);
                coreTemperature = randomIntBetween(30, 60);
                try {
                    // Update every 2 seconds.
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private int randomIntBetween(int min, int max) {
            Random rand = new Random();
            return rand.nextInt((max - min) + 1) + min;
        }
    }
}
