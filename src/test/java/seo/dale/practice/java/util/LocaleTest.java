package seo.dale.practice.java.util;

import org.junit.Test;

import java.util.Locale;

public class LocaleTest {

	@Test
	public void test() {
		Locale locale = Locale.getDefault();
		System.out.println("# Default locale : " + locale);
	}
	
}
