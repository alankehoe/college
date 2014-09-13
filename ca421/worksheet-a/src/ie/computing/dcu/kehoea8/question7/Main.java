package ie.computing.dcu.kehoea8.question7;

import static java.lang.Thread.sleep;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 21/11/2013
 * Time: 18:50
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherService weatherStation = new WeatherService();

        new SnowObserver(weatherStation);
        new HeatwaveObserver(weatherStation);
        new SpaceObserver(weatherStation);

        while(true) {
            weatherStation.notifyObservers();
            sleep(1000);
        }
    }
}