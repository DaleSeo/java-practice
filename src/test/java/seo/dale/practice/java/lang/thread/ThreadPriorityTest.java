package seo.dale.practice.java.lang.thread;

import org.junit.Test;

/**
 * The higher the priority is, the more chances to get executed by CPU.
 * @author Dale Seo
 */
public class ThreadPriorityTest {

	@Test
	public void test() throws InterruptedException {
		Thread lowThread = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.print(Thread.currentThread().getPriority());
			}
		});

		Thread highThread = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.print(Thread.currentThread().getPriority());
			}
		});

		lowThread.start();
		lowThread.setPriority(1);

		highThread.start();
		highThread.setPriority(9);

		for (int i = 0; i < 100; i++) {
			System.out.print(Thread.currentThread().getPriority());
		}

		lowThread.join();
		highThread.join();
	}


}
