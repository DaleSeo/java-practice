package seo.dale.practice.java.lang.thread;

import java.util.Scanner;

/**
 * IO jobs takes less time in multi thread.
 * @author Dale Seo
 */
public class ThreadIoPerformanceTest {

	public static void main(String[] args) throws InterruptedException {
		ThreadIoPerformanceTest test = new ThreadIoPerformanceTest();
		// test.testSingleThread();
		test.testMultiThread();
	}

	// @Test
	public void testSingleThread() throws InterruptedException {
//		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
//		System.out.println("입력하신 값은 [" + input + "]입니다.");

		Scanner io = new Scanner(System.in);
		System.out.println("아무 값이나 입력하세요.");
		String input = io.next();
		System.out.println("입력하신 값은 [" + input + "]입니다.");
		io.close();

		for (int i = 9; i > -1; i--) {
			System.out.println(i);
			Thread.sleep(1000);
		}
	}

	// @Test
	public void testMultiThread() throws InterruptedException {
		Thread inputThread = new Thread(() -> {
			Scanner io = new Scanner(System.in);
			System.out.println("아무 값이나 입력하세요.");
			String input = io.next();
			System.out.println("입력하신 값은 [" + input + "]입니다.");
			io.close();
		});

		Thread countThread = new Thread(() -> {
			for (int i = 9; i > -1; i--) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		inputThread.start();
		countThread.start();

		inputThread.join();
		countThread.join();
	}

}
