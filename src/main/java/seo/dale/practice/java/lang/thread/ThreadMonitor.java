package seo.dale.practice.java.lang.thread;

import java.util.Map;

/**
 * Monitors all threads and their call stack.
 * @author Dale Seo
 */
public class ThreadMonitor {

	public static void main(String[] args) {
		new Thread(() -> {
			try {
				Thread.sleep((int) (1000 * Math.random()));
			}catch(Exception e) {
			}
		}, "My Thread").start();

		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
			System.out.println(">>> " + entry.getKey());

			for (StackTraceElement stackTraceElement : entry.getValue()) {
				System.out.println(stackTraceElement);
			}

			System.out.println();
		}
	}

}