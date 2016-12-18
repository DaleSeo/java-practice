package seo.dale.practice.java.multithreading.thread;

public class RunnableLambdaTest {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName);
		});
		thread.setName("Thread #1");
		thread.start();
	}

}
