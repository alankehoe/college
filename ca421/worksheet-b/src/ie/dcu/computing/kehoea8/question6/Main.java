package ie.dcu.computing.kehoea8.question6;

import ie.dcu.computing.kehoea8.question5.Command;
import ie.dcu.computing.kehoea8.question5.Light.Light;
import ie.dcu.computing.kehoea8.question5.Light.LightOffCommand;
import ie.dcu.computing.kehoea8.question5.dvd.Dvd;
import ie.dcu.computing.kehoea8.question5.dvd.DvdOnCommand;
import ie.dcu.computing.kehoea8.question5.tv.Tv;
import ie.dcu.computing.kehoea8.question5.tv.TvOnCommand;

/**
 * Created by Alan Kehoe on 20/12/2013.
 */
public class Main {
    public static Macro macro;
    public static Command[] commands;

    public static Light light = new Light();
    public static Tv tv = new Tv();
    public static Dvd dvd = new Dvd();

    public static void main(String[] args) {
        commands = new Command[3];

        commands[0] = new LightOffCommand(light);
        commands[1] = new TvOnCommand(tv);
        commands[2] = new DvdOnCommand(dvd);

        macro = new Macro(commands);
        macro.execute();
    }
}
