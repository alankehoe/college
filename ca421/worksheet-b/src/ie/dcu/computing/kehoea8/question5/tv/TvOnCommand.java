package ie.dcu.computing.kehoea8.question5.tv;

import ie.dcu.computing.kehoea8.question5.Command;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */
public class TvOnCommand implements Command {
    Tv tv;

    public TvOnCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
