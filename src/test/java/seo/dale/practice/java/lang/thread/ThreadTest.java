package seo.dale.practice.java.lang.thread;

import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;

/**
 * @author Dale Seo
 */
public class ThreadTest {

	@Test(expected = IllegalThreadStateException.class)
	public void testStart() {
		Thread thread = new Thread(() -> System.out.println(Thread.currentThread()));
		thread.start();
		thread.start();
		fail();
	}

	@Test
	public void testGetName() {
		new Thread(() -> assertEquals("My thread", Thread.currentThread().getName()), "My thread").start();
	}

	@Test
	public void testGetState() throws InterruptedException {
		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(2000);
				if (Thread.currentThread().isAlive()) {
					System.out.println("My state is " + Thread.currentThread().getState());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "My thread");

		assertFalse(thread.isAlive());
		System.out.println("My state is " + thread.getState());
		thread.start();
		thread.join(); // waits for this thread to die
		assertFalse(thread.isAlive());
		System.out.println("My state is " + thread.getState());
	}

	/**
	 * If you want the threads to execute in order, call the join method right after calling the start method.
	 */
	@Test
	public void testJoin() throws InterruptedException {
		Thread th1 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.print("-");
			}
		});

		Thread th2 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.print("|");
			}
		});
		th1.start();
		th1.join();
		assertEquals(Thread.State.TERMINATED, th1.getState());

		th2.start();
		th2.join();
		assertEquals(Thread.State.TERMINATED, th2.getState());
	}

	/**
	 * https://docs.oracle.com/javase/tutorial/essential/concurrency/interrupt.html
	 */
	@Test
	public void testInterrupt() throws InterruptedException {
		Thread th = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
					System.out.printf("[%d] Running~%n", i);
				} catch (InterruptedException e) {
					System.out.printf("[%d] Interrupted!%n", i);
				}
			}
		});

		boolean isInterrupted;

		th.start();
		Thread.sleep(5000);

		isInterrupted = th.isInterrupted();
		System.out.println("- isInterrupted: " + isInterrupted);
		assertFalse(isInterrupted);

		th.interrupt();

		isInterrupted = th.isInterrupted();
		System.out.println("- isInterrupted: " + isInterrupted);
		assertTrue(isInterrupted);

		th.join();

		isInterrupted = th.isInterrupted();
		System.out.println("- isInterrupted: " + isInterrupted);
		assertFalse(isInterrupted);
	}

	@Test
	public void test1() {
		System.out.println(1);

		for (int i = 0; i < 10; i++) {
			System.out.println(2 + "" + i);
			try {
				if (i == 5) {
					throw new RuntimeException();
				}
			} catch (Exception e) {
				System.out.println(3);
			}
		}

		System.out.println(4);
	}

	@Test
	public void testGetAllStackTraces() {
		Thread thread = new Thread("My thread");
		thread.start();

		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();

		assertTrue(map.keySet().contains(thread));
		assertTrue(map.keySet().contains(Thread.currentThread()));
	}

}
