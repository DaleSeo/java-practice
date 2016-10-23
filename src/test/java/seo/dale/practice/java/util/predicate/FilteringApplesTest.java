package seo.dale.practice.java.util.predicate;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FilteringApplesTest {

	@Test
	public void test() {
		List<Apple> inventory = Arrays.asList(
				new Apple(80, "green"),
				new Apple(155, "green"),
				new Apple(120, "red")
		);

		// Method references
		List<Apple> greenApples = FilteringApples.filterApples(inventory, FilteringApples::isGreenApple);
		assertEquals(2, greenApples.size());
		assertTrue(greenApples.contains(inventory.get(0)));
		assertTrue(greenApples.contains(inventory.get(1)));

		List<Apple> heavyApples = FilteringApples.filterApples(inventory, FilteringApples::isHeavyApple);
		assertEquals(1, heavyApples.size());
		assertTrue(heavyApples.contains(inventory.get(1)));

		// Lambdas
		List<Apple> greenApples2 = FilteringApples.filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
		assertEquals(2, greenApples2.size());
		assertTrue(greenApples2.contains(inventory.get(0)));
		assertTrue(greenApples2.contains(inventory.get(1)));

		List<Apple> heavyApples2 = FilteringApples.filterApples(inventory, (Apple a) -> a.getWeight() > 150);
		assertEquals(1, heavyApples2.size());
		assertTrue(heavyApples2.contains(inventory.get(1)));

		List<Apple> weirdApples = FilteringApples.filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "brown".equals(a.getColor()));
		assertEquals(0, weirdApples.size());
	}

}