package ie.dcu.computing.kehoea8.question5.dvd;

import ie.dcu.computing.kehoea8.question5.Command;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */

public class DvdOnCommand implements Command {
    Dvd dvd;

    public DvdOnCommand(Dvd dvd) {
        this.dvd = dvd;
    }

    @Override
    public void execute() {
        dvd.on();
    }

    @Override
    public void undo() {
        dvd.off();
    }
}
