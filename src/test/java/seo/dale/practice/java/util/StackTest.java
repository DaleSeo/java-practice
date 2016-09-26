package seo.dale.practice.java.util;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.Assert.assertTrue;

public class StackTest {
	
	private Stack<Integer> stack;
	
	@Before
	public void setUp() {
		stack = new Stack<Integer>();
	}

	@Test
	public void test() {
		int[] numArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		if (stack.isEmpty()) {
			System.out.println("Stack Is Empty!!!");
		}
		
		for (int num : numArray) {
			stack.push(num);
		}
		
		for (int i = 0; i < numArray.length; i++) {
			if (stack.isEmpty()) {
				System.out.println("Stack Is Empty!!!");
			} else {
				System.out.println(stack.peek());
				stack.pop();
			}
		}
		
		try {
			stack.pop();
		} catch (Exception e) {
			System.out.println("Stack Under Flow!!!");
			assertTrue(e.getClass() == EmptyStackException.class);
		}
	}

}
