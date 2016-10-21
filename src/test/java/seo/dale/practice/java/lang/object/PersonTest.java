package seo.dale.practice.java.lang.object;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PersonTest {

	@Test
	public void testHashCode() {
		Person p1 = new Person(1L, "Dale", 34);
		Person p2 = new Person(1L, "Dale", 34);
		assertTrue(p1.hashCode() == p2.hashCode());
	}

	@Test
	public void testEquals() {
		Person p1 = new Person(1L, "Dale", 34);
		Person p2 = new Person(1L, "Dale", 34);
		assertTrue(p1.equals(p2));
	}

}
