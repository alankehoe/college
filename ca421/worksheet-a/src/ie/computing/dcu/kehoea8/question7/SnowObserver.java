package ie.computing.dcu.kehoea8.question7;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 21/11/2013
 * Time: 19:21
 */

public class SnowObserver implements Observer {
    WeatherService weatherStation;

    public SnowObserver(WeatherService weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.attach(this);
    }

    public void update() {
        int temperature = weatherStation.getTemperature();
        int humidity = weatherStation.getHumidity();

        if (temperature <= 3 && humidity >= 75) {
            System.out.print("Be careful it might snow ");
            System.out.print("Temperature : " + temperature + " ");
            System.out.println("Humidity : " + humidity);
        }
    }
}
