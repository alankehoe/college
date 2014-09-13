package ie.dcu.computing.kehoea8.question5;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */

public class Remote {
    Command[] onCommands = new Command[5];
    Command[] offCommands = new Command[5];
    Command undoCommand;

    public Remote() {
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void executeOnCommand(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void executeOffCommand(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void executeUndoCommand() {
        undoCommand.undo();
    }
}

