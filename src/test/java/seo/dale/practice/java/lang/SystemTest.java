package seo.dale.practice.java.lang;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SystemTest {

	@Test
	public void testCurrentTimeMillis() throws InterruptedException {
		long startTime = System.currentTimeMillis();
		Thread.sleep(100);
		long endTime = System.currentTimeMillis();
		
		long timeElpased = endTime - startTime;
		System.out.println("# Time elapsed : " + timeElpased);
	}

	@Test
	public void testArrayCopy() {
		int[] intArray = {1, 2, 3, 4, 5};
		int[] biggerIntArray = new int[intArray.length * 2];

		System.arraycopy(intArray, 0, biggerIntArray, 2, intArray.length);
		System.out.println(Arrays.toString(biggerIntArray));

		assertArrayEquals(new int[]{0, 0, 1, 2, 3, 4, 5, 0, 0, 0}, biggerIntArray);
	}
	
}
