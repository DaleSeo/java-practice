package seo.dale.practice.java.multithreading.daemon;

/**
 *
 */
public class DaemonTest {

	public static void main(String[] args) throws InterruptedException {
		Thread dt = new Thread(new DaemonThread(), "dt");
		dt.setDaemon(true);
		dt.start();
		Thread.sleep(5 * 1_000);
		System.out.println("Finishing program");
	}

}

class DaemonThread implements Runnable{

	@Override
	public void run() {
		while(true){
			processSomething();
		}
	}

	private void processSomething() {
		try {
			System.out.println("Processing daemon thread");
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
