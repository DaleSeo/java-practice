package seo.dale.practice.java.tutorial.concurrency.thread;

/**
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html
 */
public class SleepMessages {

	public static void main(String[] args) throws InterruptedException {
		String[] importantInfo = {
			"Mares eat oats",
			"Does eat oats",
			"Little lambs eat ivy",
			"A kid will eat ivy too"
		};

		for (String info : importantInfo) {
			Thread.sleep(1000);
			System.out.println(info);
		}
	}

}
