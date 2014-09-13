package ie.dcu.computing.kehoea8.question5.tv;

import ie.dcu.computing.kehoea8.question5.Command;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */
public class TvOffCommand implements Command {
    Tv tv;

    public TvOffCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}
