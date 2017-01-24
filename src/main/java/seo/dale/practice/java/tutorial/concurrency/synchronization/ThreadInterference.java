package seo.dale.practice.java.tutorial.concurrency.synchronization;

public class ThreadInterference {

	public static void main(String[] args) {
		Counter counter = new Counter();
		new Thread(() -> {
			counter.increment();
		}).run();
		new Thread(() -> {
			counter.decrement();
		}).run();
		System.out.println(counter.value());
	}

}
