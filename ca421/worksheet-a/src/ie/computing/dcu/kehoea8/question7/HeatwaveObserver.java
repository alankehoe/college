package ie.computing.dcu.kehoea8.question7;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 21/11/2013
 * Time: 19:21
 */

public class HeatwaveObserver implements Observer {
    WeatherService weatherStation;

    public HeatwaveObserver(WeatherService weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.attach(this);
    }

    public void update() {
        int temperature = weatherStation.getTemperature();

        if (temperature > 35) {
            System.out.print("There seems to be a heatwave ");
            System.out.println("Temperature : " + temperature);
        }
    }
}
