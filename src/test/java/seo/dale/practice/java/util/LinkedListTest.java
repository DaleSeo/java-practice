package seo.dale.practice.java.util;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class LinkedListTest {

	private LinkedList<Integer> list;
	
	@Before
	public void setUp() {
		list = new LinkedList<Integer>();
	}
	
	@Test
	public void test() {
		if (list.isEmpty()) {
			System.out.println("LinkedList is empty.");
		}
		
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println(list);
		
		for (int i = 0; i < 7; i++) {
			list.push(i);
		}
		System.out.println(list);
	}

}
