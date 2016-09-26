package seo.dale.practice.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MathTest {

	@Test
	public void testPow() {
		/* Math.pow(a, b) = a^b*/
		assertTrue(Math.pow(0, 0) == 1);
		assertTrue(Math.pow(1, 0) == 1);
		assertTrue(Math.pow(0, 1) == 0);
		assertTrue(Math.pow(1, 1) == 1);
		assertTrue(Math.pow(1, 2) == 1);
		assertTrue(Math.pow(2, 1) == 2);
		assertTrue(Math.pow(2, 2) == 4);
		assertTrue(Math.pow(2, 3) == 8);
		assertTrue(Math.pow(3, 2) == 9);
	}
	
}
