package ie.computing.dcu.kehoea8.question7;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 21/11/2013
 * Time: 19:18
 */

public interface Service {
    public void attach(Observer observer);
    public void detach(Observer observer);

    public int getTemperature();
    public int getHumidity();
    public int getPressure();

    public void notifyObservers();
}
