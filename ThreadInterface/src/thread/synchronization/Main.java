package thread.synchronization;

import java.util.function.Consumer;

import thread.synchronization.model.Counter;
import thread.synchronization.process.Process;

public class Main {
	public static void main(String[] args) {
		Counter counter = new Counter();
		Consumer<Counter> decreaseCounter = cter -> counter.decrement();
		Consumer<Counter> increaseCounter = cter -> counter.increment();
		Process processIncrement = new Process(counter, increaseCounter);
		Process processDecrement = new Process(counter, decreaseCounter);
		processDecrement.start();
		processIncrement.start();
	}
}
