package ie.dcu.computing.kehoea8.question5.Light;

import ie.dcu.computing.kehoea8.question5.Command;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
