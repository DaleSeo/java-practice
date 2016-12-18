package seo.dale.practice.java.multithreading.thread_safety;

public class ThreadSafety {

	public static void main(String[] args) throws InterruptedException {
		ProcessingThread pt = new ProcessingThread();
		Thread t1 = new Thread(pt, "t1");
		t1.start();
		Thread t2 = new Thread(pt, "t2");
		t2.start();
		//wait for threads to finish processing
		t1.join();
		t2.join();
		System.out.println("Processing count=" + pt.getCount());
	}

}

class ProcessingThread implements Runnable {

	private int count;

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " starts.");
		for (int i = 1; i < 5; i++) {
			processSomething(i);
			count++;
			System.out.println(Thread.currentThread().getName() + " : " + count);
		}
		System.out.println(Thread.currentThread().getName() + " ends.");
	}

	public int getCount() {
		return count;
	}

	private void processSomething(int i) {
		try {
			Thread.sleep(i * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}