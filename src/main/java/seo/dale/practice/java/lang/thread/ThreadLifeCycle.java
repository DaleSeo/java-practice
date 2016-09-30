package seo.dale.practice.java.lang.thread;

/**
 * @author Dale Seo
 */
public class ThreadLifeCycle {

	public static long startTime = 0;
	public static long endTime = 0;

	public static void main(String[] args) {
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
		th2.start();

		startTime = System.currentTimeMillis();

		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		endTime = System.currentTimeMillis();

		System.out.println("\nelapsed time : " + (endTime - startTime));
	}

}
