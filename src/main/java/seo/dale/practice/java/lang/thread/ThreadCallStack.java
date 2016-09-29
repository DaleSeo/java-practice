package seo.dale.practice.java.lang.thread;

/**
 * @author Dale Seo
 */
public class ThreadCallStack {

	public static void main(String[] args) {
		/* Execute on the same call stack */
		Runnable runnable = new ExceptionRunnable();
		runnable.run(); // at seo.dale.practice.java.thread.ThreadEx2.main

		/* Execute on a different call stack */
		Thread thread = new Thread(runnable);
		thread.start(); // at java.lang.Thread.run
	}

}

class ExceptionRunnable implements Runnable {
	@Override
	public void run() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
