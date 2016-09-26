package seo.dale.practice.java.util;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	@Ignore
	@Test
	public void test() throws IOException {
		Properties pp = new Properties();
		pp.load(getClass().getResourceAsStream("test.properties"));
		System.out.println(pp);
	}

}
