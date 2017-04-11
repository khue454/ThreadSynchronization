package thread.synchronization.process;

import thread.synchronization.model.SynchronizedCounter;

import java.util.function.Consumer;

/**
 * Created by Khue DZ on 11/4/2017.
 */
public class Process extends Thread {

    private Consumer<SynchronizedCounter> consumer;
    private SynchronizedCounter counter;

    public Process(SynchronizedCounter counter, Consumer<SynchronizedCounter> consumer) {
        this.counter = counter;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumer.accept(counter);
        System.out.println(counter.value());
    }
}
