package seo.dale.practice.java.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArraysTest {

	@Test
	public void testToString() {
		String[] arr = {"HTML", "CSS", "Javascript", "Java", "C++", "Spring", "MyBatis"};
		String toString = Arrays.toString(arr);
		System.out.println(toString);
	}

	@Test
	public void testAsList() {
		List<String> list = Arrays.asList("HTML", "CSS", "Javascript", "Java", "C++", "Spring", "MyBatis");
		try {
			list.add("CCC");
		} catch (Exception e) {
			assertTrue(e instanceof UnsupportedOperationException);
		}
	}

	@Test
	public void testFill() {
		int[] nums = new int[10];
		Arrays.fill(nums, -1);
		for (int n : nums) {
			if (n != -1) {
				fail();
			}
		}
	}

	@Test
	public void testCopyOfRange() {
		char[] chars = "abcde".toCharArray();
		char[] copy = Arrays.copyOfRange(chars, 2, chars.length);
		System.out.println(copy);
		assertArrayEquals("cde".toCharArray(), copy);
	}

	@Test
	public void testSort() {
		int[] arr = {1, 5, 3, 4, 2};
		Arrays.sort(arr);
		assertArrayEquals(new int[]{1, 2, 3,4, 5}, arr);
	}

	@Test
	public void testBinarySearch() throws Exception {
		int[] arr = {1, 2, 3, 4, 5}; // Array must be sorted before binary search

		// the key is found : index of the key
		assertEquals(1, Arrays.binarySearch(arr, 2));
		assertEquals(3, Arrays.binarySearch(arr, 4));

		// the key is not found : -(insertion point) - 1
		assertEquals(-1, Arrays.binarySearch(arr, 0));
		assertEquals(-6, Arrays.binarySearch(arr, 7));

		// range binary search
		assertEquals(1, Arrays.binarySearch(arr, 1, 4, 2));
		assertEquals(3, Arrays.binarySearch(arr, 1, 4, 4));
	}

}
