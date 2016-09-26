package seo.dale.practice.java;

import org.junit.Test;

public class AssertTest {
	
	public static void main(String[] args) {
	     boolean assertTest = true;
	     assert assertTest;
	     assertTest = false;
	     assert assertTest;
	}

	@Test
	public void test() {
	     boolean assertTest = true;
//		boolean assertTest = false;
	     assert assertTest;
	}
	
}
