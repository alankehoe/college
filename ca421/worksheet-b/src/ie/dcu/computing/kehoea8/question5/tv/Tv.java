package ie.dcu.computing.kehoea8.question5.tv;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */
public class Tv {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int MUTE = 0;

    // Initialise the tv with some volume.
    private int volume = LOW;

    public void on() {
        System.out.println("Tv is on");
    }

    public void off() {
        System.out.println("Tv is off");
    }

    public void high() {
        volume = HIGH;
        System.out.println("Tv volume is on high");
    }

    public void medium() {
        volume = MEDIUM;
        System.out.println("Tv volume is on medium");
    }

    public void low() {
        volume = LOW;
        System.out.println("Tv volume is on low");
    }

    public void mute() {
        volume = MUTE;
        System.out.println("Tv is muted");
    }

    public int getVolume() {
        return volume;
    }
}