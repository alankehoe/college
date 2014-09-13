package ie.dcu.computing.kehoea8.question5.garage;

import ie.dcu.computing.kehoea8.question5.Command;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */
public class GarageCloseCommand implements Command {
    Garage garage;

    public GarageCloseCommand(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void execute() {
        garage.close();
    }

    @Override
    public void undo() {
        garage.open();
    }
}
