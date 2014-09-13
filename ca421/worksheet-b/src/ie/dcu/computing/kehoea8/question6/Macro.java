package ie.dcu.computing.kehoea8.question6;

import ie.dcu.computing.kehoea8.question5.Command;

/**
 * Created by Alan Kehoe on 20/12/2013.
 */
public class Macro implements Command {
    Command[] commands;

    public Macro(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }
}
