package seo.dale.practice.java.lang.thread;

import org.junit.Test;

/**
 * suspend(), resume(), stop() 메소드는 쓰레드를 교착상태(dead-lock)에 빠뜨릴 가능성이 있기 때문에 deprecated 되었다.
 * @author Dale Seo
 */
public class ThreadDeprecated {

	@Test
	public void test() {
		Runnable runnable = () -> {
			while (true) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread th1 = new Thread(runnable, "*");
		Thread th2 = new Thread(runnable, "**");
		Thread th3 = new Thread(runnable, "***");

		th1.start();
		th2.start();
		th3.start();

		try {
			Thread.sleep(2000); // put the current thread waiting (No clue which one is the current thread)
			th1.suspend(); // put th1 waiting
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume(); // put th1 runnable
			Thread.sleep(3000);
			th1.stop(); // put th1 terminated
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
