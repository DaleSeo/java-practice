package seo.dale.practice.java.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author 서대영/Store기술개발팀/SKP
 */
public class ArrayListTest {

	@Test
	public void testRemove() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}

		assertEquals(2, list.get(2).intValue());
		assertEquals(9, list.get(9).intValue());
		list.remove(2); // removed and shifted
		assertEquals(2 + 1, list.get(2).intValue());
		try {
			list.get(9).intValue();
			fail();
		} catch (IndexOutOfBoundsException e) {
		}
	}

}
