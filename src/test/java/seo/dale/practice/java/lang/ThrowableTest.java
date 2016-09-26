package seo.dale.practice.java.lang;

import org.junit.Test;

public class ThrowableTest {

	@Test
	public void printStackTraceWithCause() {
		Throwable throwable = new Exception(new Exception(new Exception("Error")));
		throwable.printStackTrace();
	}
	
	@Test
	public void printStackTraceWithMessage() {
		Throwable throwable = new Exception("High", new Exception("Mid", new Exception("Low")));
		throwable.printStackTrace();
	}
	
	
	@Test
	public void getStackTrace() {
		Throwable throwable = new RuntimeException(new NullPointerException());
		StackTraceElement[] stackTraceElements = throwable.getStackTrace();
		for (StackTraceElement ste : stackTraceElements) {
			System.out.println(ste);
		}
	}
	
	@Test
	public void getLocalizedMessage() {
		Throwable throwable = new RuntimeException(new NullPointerException());
		System.out.println(throwable.getLocalizedMessage());
	}
	
	@Test
	public void getCause() {
		Throwable throwable = new RuntimeException(new NullPointerException());
		throwable.getCause().printStackTrace();
	}
	
	@Test
	public void testToString() {
		Throwable throwable = new RuntimeException(new NullPointerException());
		String str = throwable.toString();
		System.out.println(str);
	}

}
