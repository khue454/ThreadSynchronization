package thread.synchronization;

import thread.synchronization.model.Counter;
import thread.synchronization.process.Process;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Consumer<Counter> counterConsumer = Counter::increment;
        Consumer<Counter> counterConsumer1 = counter1 -> System.out.println(counter1.getC());
        Process process = new Process(counter,counterConsumer);
        Process process1 = new Process(counter,counterConsumer1);
        process.start();
        process1.start();
    }
}
