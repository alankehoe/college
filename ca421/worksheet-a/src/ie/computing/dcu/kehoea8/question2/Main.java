package ie.computing.dcu.kehoea8.question2;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: alan
 * Date: 19/11/2013
 * Time: 18:43
 */

public class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Vector<Integer> vector = new Vector<Integer>(list);

        Enumeration<Integer> enumerator = vector.elements();

        MyIterator myIterator = new MyIterator(enumerator);
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }
    }
}

