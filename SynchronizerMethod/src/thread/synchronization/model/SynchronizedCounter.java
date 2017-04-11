package thread.synchronization.model;

/**
 * Created by Khue DZ on 11/4/2017.
 */
public class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
}
