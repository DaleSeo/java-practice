package seo.dale.practice.java.lamda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class LambdaTest {

	@Test
	public void testThread() throws Exception {
		/*
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("This is a closure thread.");
			}
		}).start();
		*/
		new Thread(() -> {
			System.out.println("This is a lambda thread.");
		}).start();
	}

	@Test
	public void testLoop() throws Exception {
		List<Integer> list = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		/*
		for (int i : list) {
			System.out.println(i);
		}
		*/
		/*
		list.forEach(i -> System.out.println(i));
		*/
		list.forEach(System.out::println); // 1 step further : method reference
	}

	@Test
	public void testPredicate() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		assertEquals(15, sum(numbers, t -> true));
		assertEquals(6, sum(numbers, t -> t % 2 == 0));
		assertEquals(9, sum(numbers, t -> t > 3));
	}

	private int sum(List<Integer> numbers, Predicate<Integer> p) {
		int total = 0;
		for (int num : numbers){
			if (p.test(num)) {
				total += num;
			}
		}
		return total;
	}

}
