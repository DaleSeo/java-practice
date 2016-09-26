package seo.dale.practice.java.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Formatter;

import static org.junit.Assert.assertEquals;

public class FormatterTest {

	Formatter formatter;
	
	@Before
	public void beforeClass() {
		formatter = new Formatter(); // Use a StringBuffer as the output
	}
	
	@After
	public void afterClass() {
		formatter.close();
	}
	
	@Test
	public void emptyFormat() {
		formatter.format("", 123456789);
		assertEquals("", formatter.toString());
	}
	
	@Test
	public void addCommas() {
		formatter.format("%,d", 123456789);
		assertEquals("123,456,789", formatter.toString());
	}
	
	@Test
	public void includePlusSign() {
		formatter.format("%+d", 123456789);
		assertEquals("+123456789", formatter.toString());
	}
	
	@Test
	public void includeMinusSign() {
		formatter.format("%+d", -123456789);
		assertEquals("-123456789", formatter.toString());
	}
	
	@Test
	public void encloseNegativeNumbersInparentheses() {
		formatter.format("%(d", -123456789);
		assertEquals("(123456789)", formatter.toString());
	}
	
	@Test
	public void width() {
		formatter.format("%12.3f", 12345.6789);
		assertEquals("   12345.679", formatter.toString());
	}
	
	@Test
	public void widthWithZeroPadding() {
		formatter.format("%012.3f", 12345.6789);
		assertEquals("00012345.679", formatter.toString());
	}
	
	@Test
	public void leftJustified() {
		formatter.format("%-10s", "abcdefg");
		assertEquals("abcdefg   ", formatter.toString());
	}
	
	@Test
	public void argumentIndex() {
		formatter.format("%3$s %2$s %1$s", "First", "Second", "Third");
		assertEquals("Third Second First", formatter.toString());
	}

}
