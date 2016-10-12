package seo.dale.practice.java.util.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MatcherTest {

	/**
	 * find() - true if the pattern is found from the string
	 * matches() - true if the pattern matches the entire string
	 */
	@Test
	public void testFindVsMatches() {
		Pattern p = Pattern.compile("\\d\\d\\d");
		Matcher m = p.matcher("a123b");
		assertTrue(m.find());
		assertFalse(m.matches());

		p = Pattern.compile("^\\d\\d\\d$");
		m = p.matcher("123");
		assertTrue(m.find());
		assertTrue(m.matches());
	}

}
