package ie.dcu.computing.kehoea8.question8;

import ie.dcu.computing.kehoea8.question5.Command;
import ie.dcu.computing.kehoea8.question5.dvd.Dvd;
import ie.dcu.computing.kehoea8.question5.dvd.DvdOffCommand;
import ie.dcu.computing.kehoea8.question5.dvd.DvdOnCommand;
import ie.dcu.computing.kehoea8.question5.tv.Tv;
import ie.dcu.computing.kehoea8.question5.tv.TvOffCommand;
import ie.dcu.computing.kehoea8.question5.tv.TvOnCommand;

/**
 * Created by Alan Kehoe on 20/12/2013.
 */
public class Main {
    private static Tv tv = new Tv();
    private static Dvd dvd = new Dvd();

    public static void main(String[] args) {
        Macro macro = new Macro();

        TvOnCommand tvOnCommand = new TvOnCommand(tv);
        TvOffCommand tvOffCommand = new TvOffCommand(tv);
        DvdOnCommand dvdOnCommand = new DvdOnCommand(dvd);
        DvdOffCommand dvdOffCommand = new DvdOffCommand(dvd);

        macro.addCommand(tvOffCommand);
        macro.addCommand(dvdOffCommand);

        macro.clickLearn();
        macro.addCommand(tvOnCommand);
        macro.unClickLearn();

        macro.clickLearn();
        macro.addCommand(dvdOnCommand);
        macro.unClickLearn();

        System.out.println("All Commands:");
        for (Command command : macro.getCommands()) {
            command.execute();
        }

        System.out.println("\n");

        System.out.println("Learned Commands:");
        for (Command command : macro.getLearnedCommands()) {
            command.execute();
        }
    }
}
