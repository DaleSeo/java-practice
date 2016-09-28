package seo.dale.practice.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Dale Seo
 */
public class ThreadTest {

	@Test(expected = IllegalThreadStateException.class)
	public void testStart() {
		Runnable runnable = () -> System.out.println(Thread.currentThread());
		Thread thread = new Thread(runnable);
		thread.start();
		thread.start();
		fail();
	}

	@Test
	public void testGetName() {
		Runnable runnable = () -> assertEquals("My thread", Thread.currentThread().getName());
		new Thread(runnable, "My thread").start();
	}

}
