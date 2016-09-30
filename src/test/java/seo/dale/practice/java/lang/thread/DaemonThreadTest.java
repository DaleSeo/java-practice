package seo.dale.practice.java.lang.thread;

import org.junit.Test;

/**
 * 부모 쓰레드가 종료될 때, 데몬 쓰레드도 종료된다.
 * @author Dale Seo
 */
public class DaemonThreadTest {

	private boolean autoSave = false;

	@Test
	public void test() {
		Thread daemonThread = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(3 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (autoSave) {
					System.out.println("Saved successfully.");
				}
			}
		});

		daemonThread.setDaemon(true); // Make it to be a daemon thread
		daemonThread.start();

		for (int i = 1; i <= 20; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
			if (i == 5) {
				autoSave = true;
			}
		}

		System.out.println("Finishes the program");
	}

}
