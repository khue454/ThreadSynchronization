package thread.synchronization;

import thread.synchronization.model.Philosopher;

/**
 * Created by Khue DZ on 11/4/2017.
 */
public class Main {
    public static void main(String[] args) {
        Thread philosopher1 = new Philosopher();
        Thread philosopher2 = new Philosopher();
        Thread philosopher3 = new Philosopher();
        Thread philosopher4 = new Philosopher();
        Thread philosopher5 = new Philosopher();
        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();
    }

}
