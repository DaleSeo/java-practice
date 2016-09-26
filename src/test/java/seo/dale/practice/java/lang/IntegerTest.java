package seo.dale.practice.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerTest {
	
	@Test
	public void testParseInt() {
		assertEquals(11, Integer.parseInt("1011", 2));
	}
	
	@Test
	public void testBaseRelated() {
		assertEquals("1011", Integer.toBinaryString(11));
		assertEquals("13", Integer.toOctalString(11));
		assertEquals("b", Integer.toHexString(11));
	}

	@Test
	public void absoluteOfMostNagativeValue() {
		final int mostNegative = Integer.MIN_VALUE;
		final int negated = Math.abs(mostNegative);
		System.out.println(mostNegative);
		System.out.println(negated);
		assertEquals(mostNegative, negated);
	}

	@Test
	public void testCompare() {
		assertEquals(0, Integer.compare(1, 1));
		assertEquals(-1, Integer.compare(-1, 1));
		assertEquals(1, Integer.compare(1, -1));
	}
	
	
}
