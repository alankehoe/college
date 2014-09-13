package ie.dcu.computing.kehoea8.question2;

import ie.dcu.computing.kehoea8.question1.BasicSingleton;

/**
 * Created by Alan Kehoe on 17/12/2013.
 */

// A race condition happens when an object gets created while another object is in the middle of creation.

public class Main {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000000; i++) {
                    BasicSingleton.getInstance();
                }
            }
        };

        Thread one = new Thread(runnable);
        Thread two = new Thread(runnable);

        one.start();
        two.start();

        System.out.println(BasicSingleton.getCounter());
        ;
    }
}
