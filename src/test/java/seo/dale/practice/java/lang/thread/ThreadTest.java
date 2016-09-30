package seo.dale.practice.java.lang.thread;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

	@Test
	public void testGetAllStackTraces() {
		Thread thread = new Thread("My thread");
		thread.start();

		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();

		assertTrue(map.keySet().contains(thread));
		assertTrue(map.keySet().contains(Thread.currentThread()));
	}

}
