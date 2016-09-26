package seo.dale.practice.java.util;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import static org.junit.Assert.assertTrue;

public class QueueTest {
	
	private Queue<Integer> queue;
	
	@Before
	public void setUp() {
		queue = new ArrayBlockingQueue<Integer>(10);
	}

	@Test
	public void test() {
		int[] numArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		if (queue.isEmpty()) {
			System.out.println("Queue Is Empty!!!");
		}
		
		for (int num : numArray) {
			queue.add(num);
		}
		
		for (int i = 0; i < numArray.length - 3; i++) {
			if (queue.isEmpty()) {
				System.out.println("Queue Is Empty!!!");
			} else {
				System.out.println(queue.element());
				queue.remove();
			}
		}
		
		try {
			queue.remove();
		} catch (Exception e) {
			System.out.println("Queue Under Flow!!!");
			assertTrue(e.getClass() == NoSuchElementException.class);
		}
		
		queue.add(11);
		queue.add(12);
	}

}
