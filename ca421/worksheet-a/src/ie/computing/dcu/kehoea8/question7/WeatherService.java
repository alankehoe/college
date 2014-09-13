package ie.computing.dcu.kehoea8.question7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 21/11/2013
 * Time: 18:32
 */

public class WeatherService implements Service {
    private int temperature;
    private int humidity;
    private int pressure;

    private List<Observer> observerList;
    private WeatherSensor weatherSensor = new WeatherSensor();

    public WeatherService() {
        this.observerList = new ArrayList<Observer>();
        this.weatherSensor.start();
    }

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public int getTemperature() {
        return temperature;
    }

    @Override
    public int getHumidity() {
        return humidity;
    }

    @Override
    public int getPressure() {
        return pressure;
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    class WeatherSensor extends Thread {
        @Override
        public synchronized void run() {
            while (true) {
                humidity = randomIntBetween(60, 100);
                pressure = randomIntBetween(0, 60);
                temperature = randomIntBetween(0, 50);
                try {
                    // Sleep for a random period between 5 and 15 seconds.
                    sleep(randomIntBetween(5, 15) * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private int randomIntBetween(int min, int max) {
            Random rand = new Random();
            return rand.nextInt((max - min) + 1) + min;
        }
    }
}