package seo.dale.practice.java.lamda;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IAddableTest {


	@Test
	public void testAdd() throws Exception {
		IAddable<String> stringAdder = (String s1, String s2) -> s1 + s2;
		assertEquals("ABCXYZ", stringAdder.add("ABC", "XYZ"));

		IAddable<Integer> square = (i1, i2) -> i1 * i2;
	}

}