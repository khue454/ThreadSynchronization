package thread.synchronization.process;

import java.util.function.Consumer;

import thread.synchronization.model.Counter;

public class Process extends Thread {

	private Consumer<Counter> consumer;
	private Counter counter;

	public Process(Counter counter, Consumer<Counter> consumer) {
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
