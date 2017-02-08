package seo.dale.practice.java.tutorial.concurrency.liveness;

public class Deadlock {
	static class Friend {
		private final String name;
		public Friend(String name) {
			this.name = name;
		}
		public String getName() {
			return this.name;
		}
		public synchronized void bow(Friend bower) {
			System.out.format("%s: %s has bowed to me!%n", this.name, bower.getName());
			bower.bowBack(this);
		}
		public synchronized void bowBack(Friend bower) {
			System.out.format("%s: %s has bowed back to me!%n", this.name, bower.getName());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");

		Thread th1 = new Thread(() -> alphonse.bow(gaston));
		Thread th2 = new Thread(() -> gaston.bow(alphonse));

		th1.start();
		// th1.join();
		th2.start();
	}
}
