package seo.dale.practice.java.lang.object;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;

public class ObjectTest {

	@Test
	public void testHashCode() {
		assertNotSame(new Object().hashCode(), new Object().hashCode());
	}

	@Test
	public void testEquals() {
		Object obj = new Object();
		Object obj2 = new Object();
		assertFalse(obj.equals(obj2));
	}

}
