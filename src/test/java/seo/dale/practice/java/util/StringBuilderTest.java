package seo.dale.practice.java.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringBuilderTest {

	@Test
	public void test() {
		StringBuilder strBuilder = new StringBuilder("This is a text.");
		
		strBuilder.setCharAt(14, '?');
		assertEquals("This is a text?", strBuilder.toString());

		strBuilder.insert(7, "n't");
		assertEquals("This isn't a text?", strBuilder.toString());
		
		strBuilder.append(" He said.");
		assertEquals("This isn't a text? He said.", strBuilder.toString());
		
		strBuilder.reverse();
		assertEquals(".dias eH ?txet a t'nsi sihT", strBuilder.toString());
	}

}
