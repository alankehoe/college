package ie.computing.dcu.kehoea8.question2;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 20/11/2013
 * Time: 14:32
 */

public class MyIterator implements Iterator {
    private final Enumeration enumeration;

    public MyIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        System.out.println("Not implemented");
    }
}