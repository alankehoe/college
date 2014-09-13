package ie.dcu.computing.kehoea8.question5.dvd;

import ie.dcu.computing.kehoea8.question5.Command;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */

public class DvdOffCommand implements Command {
    Dvd dvd;

    public DvdOffCommand(Dvd dvd) {
        this.dvd = dvd;
    }

    @Override
    public void execute() {
        dvd.off();
    }

    @Override
    public void undo() {
        dvd.on();
    }
}
