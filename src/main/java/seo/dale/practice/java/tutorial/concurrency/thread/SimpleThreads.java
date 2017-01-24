package seo.dale.practice.java.tutorial.concurrency.thread;

public class SimpleThreads {

	public static void main(String[] args) throws InterruptedException {
		long patience = 10 * 1000; // 10 secs

		threadMessage("Starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(() -> {
			String[] importantInfo = {
					"Mares eat oats",
					"Does eat oats",
					"Little lambs eat ivy",
					"A kid will eat ivy too"
			};

//			try {
				for (String info : importantInfo) {
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						threadMessage("Keep working!");
					}
					threadMessage(info);
				}
//			} catch (InterruptedException e) {
//				threadMessage("I wasn't done!");
//			}
		});

		t.start();

		threadMessage("Waiting for MessageLoop thread to finish");
		while (t.isAlive()) {
			threadMessage("Still waiting...");
			t.join(1000);
			long endTime = System.currentTimeMillis();
			if ((endTime - startTime) > patience && t.isAlive()) {
				threadMessage("Tired of waiting!");
				t.interrupt();
				// t.join(); // wait indefinitely
			}
		}
		threadMessage("Finally");
	}

	private static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}

}
