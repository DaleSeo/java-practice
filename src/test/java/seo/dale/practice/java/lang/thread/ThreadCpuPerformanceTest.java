package seo.dale.practice.java.lang.thread;

import org.junit.Test;

/**
 * CPU jobs takes more time in multi thread due to context switching.
 * @author Dale Seo
 */
public class ThreadCpuPerformanceTest {

	@Test
	public void testSingleThread() {
		long startTime, endTime;

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			System.out.print("-");
		}
		endTime = System.currentTimeMillis();
		System.out.println("\nThe elapsed time 1 : " + (endTime - startTime));

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			System.out.print("|");
		}
		endTime = System.currentTimeMillis();
		System.out.println("\nThe elapsed time 2 : " + (endTime - startTime));
	}

	@Test
	public void testMultiThread() throws InterruptedException {
		Thread thread1 = new Thread(() -> {
			long startTime, endTime;

			startTime = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++) {
				System.out.print("-");
			}
			endTime = System.currentTimeMillis();
			System.out.println("\nThe elapsed time 1 : " + (endTime - startTime));
		});

		Thread thread2 = new Thread(() -> {
			long startTime, endTime;

			startTime = System.currentTimeMillis();
			for (int i = 0; i < 1000; i++) {
				System.out.print("|");
			}
			endTime = System.currentTimeMillis();
			System.out.println("\nThe elapsed time 2 : " + (endTime - startTime));
		});

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();
	}

}
