package seo.dale.practice.java.util.sorted;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author 서대영(DAEYOUNG SEO)/Onestore/SKP
 */
public class TreeMapTest {

	private TreeMap<Integer, Node> map;

	@Before
	public void setUp() {
		map = new TreeMap<>();
		map.put(1, new Node(1, "Dale", 70));
		map.put(2, new Node(2, "Kate", 80));
		map.put(3, new Node(3, "Tom", 90));
		map.put(4, new Node(4, "Ross", 100));
		map.put(5, new Node(5, "Monica", 90));
		map.put(6, new Node(6, "Rachel", 60));
		map.put(7, new Node(7, "Joy", 60));
		map.put(8, new Node(8, "Denny", 90));
		map.put(9, new Node(9, "Jack", 70));
	}

	@Test
	public void testDescendingMap() {
		Map<Integer, Node> descendingMap = map.descendingMap();
		descendingMap.forEach((key, val) -> System.out.println(val));
	}

	@Test
	public void testSubMap() {
		Map<Integer, Node> subMap = map.subMap(3, 7);
		subMap.forEach((key, val) -> System.out.println(val));
	}

	static class Node {
		int id;
		String name;
		int score;
		Date date;

		public Node(int id, String name, int score) {
			this.id = id;
			this.name = name;
			this.score = score;
			this.date = new Date();
		}

		@Override
		public String toString() {
			return "Node{" +
					"id=" + id +
					", name='" + name + '\'' +
					", score=" + score +
					", created=" + date +
					'}';
		}
	}

}
