package ie.dcu.computing.ca421.factory;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 22/10/2013
 * Time: 09:37
 */
public abstract class Car {
    /*
    The difference between an interface and an abstract class is

    1) a class can implement multiple interfaces
    2) a class can only extend one abstract class
    3) all methods defined in an interface must be public
    4) methods defined in an abstract class can be private, public, protected
    5) methods in an abstract class can have functionality

    */

    protected abstract String carType();
}
