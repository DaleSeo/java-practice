package seo.dale.practice.java.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author 서대영(DAEYOUNG SEO)/Onestore/SKP
 */
public class RandomTest {

	/**
	 * If the seeds of two Random object are the same,
	 * they generate values in the same order.
	 */
	@Test
	public void testSeed() {
		Random random = new Random(1);
		Random random2 = new Random(1);
		for (int i = 0; i < 100; i++) {
			assertEquals(random.nextInt(), random2.nextInt());
		}
	}

	@Test
	public void testNextInt() {
		int[] counts = new int[10];
		int seed = (int) (Math.random() * 10);
		Random random = new Random(seed);
		for (int i = 0; i < 10000; i++) {
			counts[random.nextInt(10)] ++;
		}
		for (int count : counts) {
			assertTrue(count > 800 && count < 1200);
		}
		System.out.println(">>> " + Arrays.toString(counts));
	}

}
