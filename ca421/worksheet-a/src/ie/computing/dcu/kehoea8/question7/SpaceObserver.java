package ie.computing.dcu.kehoea8.question7;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 21/11/2013
 * Time: 19:21
 */

public class SpaceObserver implements Observer {
    WeatherService weatherStation;

    public SpaceObserver(WeatherService weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.attach(this);
    }

    public void update() {
        int pressure = weatherStation.getPressure();

        if (pressure < 10) {
            System.out.print("Houston you have a problem ");
            System.out.println("Pressure : " + pressure);
        }
    }
}
