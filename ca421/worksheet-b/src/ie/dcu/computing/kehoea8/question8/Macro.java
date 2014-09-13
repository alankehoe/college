package ie.dcu.computing.kehoea8.question8;

import ie.dcu.computing.kehoea8.question5.Command;

import java.util.ArrayList;

/**
 * Created by Alan Kehoe on 20/12/2013.
 */
public class Macro implements Command {
    public static Boolean learnWasClicked = false;
    ArrayList<Command> commands = new ArrayList<Command>();
    ArrayList<Command> learnedCommands = new ArrayList<Command>();

    public Macro() {
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

    public void addCommand(Command command) {
        commands.add(command);
        if (learnWasClicked) {
            learnedCommands.add(command);
        }
    }

    public void clickLearn() {
        learnWasClicked = true;
    }

    public void unClickLearn() {
        learnWasClicked = false;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }

    public ArrayList<Command> getLearnedCommands() {
        return learnedCommands;
    }
}
