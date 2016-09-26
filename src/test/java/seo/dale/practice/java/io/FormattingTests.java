package seo.dale.practice.java.io;

import org.junit.Test;

public class FormattingTests {

	@Test
	public void test() {
		int i = 2;
        double r = Math.sqrt(i);
        
        System.out.format("The square root of %d is %f.%n", i, r);
        System.out.printf("The square root of %d is %f.%n", i, r);
	}
	
}
