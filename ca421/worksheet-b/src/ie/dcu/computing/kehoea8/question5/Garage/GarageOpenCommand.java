package ie.dcu.computing.kehoea8.question5.garage;

import ie.dcu.computing.kehoea8.question5.Command;

/**
 * Created by Alan Kehoe on 19/12/2013.
 */
public class GarageOpenCommand implements Command {
    Garage garage;

    public GarageOpenCommand(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void execute() {
        garage.open();
    }

    @Override
    public void undo() {
        garage.close();
    }
}
