package ie.dcu.computing.chi;

/**
 * Created by SuperTime on 18/03/2014.
 */
public class MultiplicativeRandom {
    // Linear congruential values for x(i+1) = (a * x(i) + b) % m.
    final static int a = 13;
    final static int b = 0;
    final static int m = 31;

    // Current value for returning.
    int x;

    public MultiplicativeRandom() {
        // Constructor simply sets value to half of m, equivalent to 0.5.
        x = m / 2;
    }

    int next() {
        // Calculate next value in sequence.
        x = (a * x + b) % m;

        return x;
    }
}
