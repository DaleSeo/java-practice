package seo.dale.practice.java.util;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CollectionsTest {

	@Test
	public void testSort() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(3);
		numbers.add(1);
		numbers.add(2);

		Collections.sort(numbers);
		assertEquals(Arrays.asList(1, 2, 3), numbers);

		Collections.sort(numbers, Collections.reverseOrder());
		assertEquals(Arrays.asList(3, 2, 1), numbers);
	}

	@Test
	public void testUnmodifiableList() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);

		List<Integer> unmodifiableNumbers = Collections.unmodifiableList(numbers);

		assertEquals(Integer.valueOf(1), unmodifiableNumbers.get(0));
		numbers.remove(0); // Warning! The original list is still modifiable.
		assertEquals(Integer.valueOf(2), unmodifiableNumbers.get(0));

		try {
			unmodifiableNumbers.remove(0);
			fail();
		} catch (UnsupportedOperationException e) {
			return;
		}
	}

	@Test
	public void testSngletonMap() {
		Map<Integer, String> map = Collections.singletonMap(1, "abc");
		System.out.println("# singletonMap : " + map);
	}
	
	@Test
	public void testSingletonList() {
		List<String> list = Collections.singletonList("abc");
		System.out.println("# singletonList : " + list);
	}

}
