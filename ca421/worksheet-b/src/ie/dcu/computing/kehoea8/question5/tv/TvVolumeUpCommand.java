package ie.dcu.computing.kehoea8.question5.tv;

import ie.dcu.computing.kehoea8.question5.Command;

/**
 * Created by Alan Kehoe on 20/12/2013.
 */
public class TvVolumeUpCommand implements Command {
    Tv tv;
    int previousVolume;

    public TvVolumeUpCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        previousVolume = tv.getVolume();
        tv.high();
    }

    @Override
    public void undo() {
        if (previousVolume == Tv.HIGH) {
            tv.high();
        } else if (previousVolume == Tv.MEDIUM) {
            tv.medium();
        } else if (previousVolume == Tv.LOW) {
            tv.low();
        } else if (previousVolume == Tv.MUTE) {
            tv.mute();
        }
    }
}
