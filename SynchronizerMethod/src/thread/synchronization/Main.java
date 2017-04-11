package thread.synchronization;

import thread.synchronization.model.SynchronizedCounter;
import thread.synchronization.process.Process;

import java.util.function.Consumer;

/**
 * Created by Khue DZ on 11/4/2017.
 */
public class Main {
    public static void main(String[] args) {
        SynchronizedCounter counter = new SynchronizedCounter();
        Consumer<SynchronizedCounter> decreaseCounter = cter -> counter.decrement();
        Consumer<SynchronizedCounter> increaseCounter = cter -> counter.increment();
        Process processIncrement = new Process(counter, increaseCounter);
        Process processDecrement = new Process(counter, decreaseCounter);
        processIncrement.start();
        processDecrement.start();
    }
}
