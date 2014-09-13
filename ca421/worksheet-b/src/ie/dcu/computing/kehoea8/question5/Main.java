package ie.dcu.computing.kehoea8.question5;

import ie.dcu.computing.kehoea8.question5.Light.Light;
import ie.dcu.computing.kehoea8.question5.Light.LightOffCommand;
import ie.dcu.computing.kehoea8.question5.Light.LightOnCommand;
import ie.dcu.computing.kehoea8.question5.dvd.Dvd;
import ie.dcu.computing.kehoea8.question5.dvd.DvdOffCommand;
import ie.dcu.computing.kehoea8.question5.dvd.DvdOnCommand;
import ie.dcu.computing.kehoea8.question5.garage.Garage;
import ie.dcu.computing.kehoea8.question5.garage.GarageCloseCommand;
import ie.dcu.computing.kehoea8.question5.garage.GarageOpenCommand;
import ie.dcu.computing.kehoea8.question5.tv.*;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */

public class Main {
    private static Tv tv = new Tv();
    private static Dvd dvd = new Dvd();
    private static Light light = new Light();
    private static Garage garage = new Garage();

    private static Remote remote = new Remote();

    public static void main(String[] args) {
        initialiseRemote();
        turnEverythingOnAndUndo();
        turnEveryThingOffAndUndo();
    }

    public static void initialiseRemote() {
        remote.setCommand(0, new TvOnCommand(tv), new TvOffCommand(tv));
        remote.setCommand(1, new TvVolumeUpCommand(tv), new TvVolumeDownCommand(tv));
        remote.setCommand(2, new DvdOnCommand(dvd), new DvdOffCommand(dvd));
        remote.setCommand(3, new LightOnCommand(light), new LightOffCommand(light));
        remote.setCommand(4, new GarageOpenCommand(garage), new GarageCloseCommand(garage));
    }

    public static void turnEverythingOnAndUndo() {
        for (int i = 0; i < 5; i++) {
            remote.executeOnCommand(i);
            remote.executeUndoCommand();

        }
    }

    public static void turnEveryThingOffAndUndo() {
        for (int i = 0; i < 5; i++) {
            remote.executeOffCommand(i);
            remote.executeUndoCommand();
        }
    }
}
