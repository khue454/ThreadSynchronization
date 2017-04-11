package thread.synchronization.process;

import thread.synchronization.model.Counter;

import java.util.function.Consumer;

/**
 * Created by Khue DZ on 11/4/2017.
 */
public class Process extends Thread {
    private Counter counter;
    private Consumer<Counter> counterConsumer;

    public Process(Counter counter, Consumer<Counter> counterConsumer) {
        this.counter = counter;
        this.counterConsumer = counterConsumer;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counterConsumer.accept(counter);
    }
}
