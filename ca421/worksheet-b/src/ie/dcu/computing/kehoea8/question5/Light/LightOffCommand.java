package ie.dcu.computing.kehoea8.question5.Light;

import ie.dcu.computing.kehoea8.question5.Command;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
