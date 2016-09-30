package seo.dale.practice.java.lang.thread;

import java.util.Scanner;

/**
 * 10초 동안 사용자가 입력하지 않으면 종료하는 프로그램 예제
 * @author Dale Seo
 */
public class InputTimeout {

	private static boolean done = false;

	public static void main(String[] args) {
		System.out.println("10초 안에 값을 입력해야 합니다.");

		Thread inputThread = new Thread(() -> {
			Scanner io = new Scanner(System.in);
			String input = io.next();
			done = true;
			System.out.println("입력하신 값은 [" + input + "]입니다.");
			io.close();
		});

		Thread countThread = new Thread(() -> {
			for (int i = 9; i > -1; i--) {
				if (done) return;
				System.out.println(i + "초 남았습니다.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("10초 동안 값이 입력되지 않아 종료합니다.");
			System.exit(0);
		});

		inputThread.start();
		countThread.start();
	}

}
