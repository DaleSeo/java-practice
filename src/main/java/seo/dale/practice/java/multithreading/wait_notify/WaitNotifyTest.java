package seo.dale.practice.java.multithreading.wait_notify;

public class WaitNotifyTest {

	public static void main(String[] args) {
		Message msg = new Message("process it");

		Waiter waiter1 = new Waiter(msg);
		new Thread(waiter1, "Waiter #1").start();

		Waiter waiter2 = new Waiter(msg);
		new Thread(waiter2, "Waiter #2").start();

		Notifier notifier = new Notifier(msg);
		new Thread(notifier, "Notifier").start();

		System.out.println("All the threads are started");
	}

}
