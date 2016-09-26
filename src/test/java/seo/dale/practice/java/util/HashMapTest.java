package seo.dale.practice.java.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author 서대영(DAEYOUNG SEO)/Onestore/SKP
 */
public class HashMapTest {

	@Test
	public void testArrayValue() throws Exception {
		Map<String, String[]> map = new HashMap<>();
		map.put("A", new String[]{"a1", "a2", "a3"});
		map.put("B", new String[]{"b1", "b2"});
		map.put("C", new String[]{"c1"});

		assertNull(map.get(null));

		String[] arrayB = map.get("B");
		System.out.println(Arrays.toString(arrayB));

		arrayB[1] = "b3";

		/**
		 * Since arrayB and map.get("B") reference the same array
		 */
		assertEquals("b3", map.get("B")[1]);
	}

}
