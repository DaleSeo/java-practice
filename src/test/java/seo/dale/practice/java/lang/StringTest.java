package seo.dale.practice.java.lang;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StringTest {

	@Test
    public void testIndexOf() {
	    String text = "Can you hear me?  Hello, hello?";
        assertEquals(8, text.indexOf("he"));
        assertEquals(18, text.indexOf("He"));
        assertEquals(-1, text.indexOf("Hi"));
    }

	@Test
	public void testSplit() {
        String text = "Can you hear me?  Hello, hello?";

		String[] words = text.split(" ");
		System.out.println(Arrays.toString(words));
		assertArrayEquals(new String[]{"Can", "you", "hear", "me?", "", "Hello,", "hello?"}, words);

        String[] words2 = text.split(" +"); // regex
        System.out.println(Arrays.toString(words2));
        assertArrayEquals(new String[]{"Can", "you", "hear", "me?", "Hello,", "hello?"}, words2);

		String[] words3 = text.split("\\s+"); // regex
		System.out.println(Arrays.toString(words3));
		assertArrayEquals(new String[]{"Can", "you", "hear", "me?", "Hello,", "hello?"}, words3);
	}

	@Test
	public void testJoin() {
		String[] words = new String[]{"find", "you", "will"};
		String message = String.join(" ", words);
		System.out.printf(message);
		assertEquals("find you will", message);
	}

	@Test
	public void testSubString() {
		String message = "find you will";
		assertEquals("you will", message.substring(5));
		assertEquals("you", message.substring(5, 8));
	}

}
