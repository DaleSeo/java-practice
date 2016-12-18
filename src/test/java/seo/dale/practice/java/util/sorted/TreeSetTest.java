package seo.dale.practice.java.util.sorted;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author 서대영(DAEYOUNG SEO)/Onestore/SKP
 */
public class TreeSetTest {

	private TreeSet<Node> set;

	@Before
	public void setUp() {
		set = new TreeSet<>();
		set.add(new Node(1, "Dale", 70));
		set.add(new Node(2, "Kate", 80));
		set.add(new Node(3, "Tom", 90));
		set.add(new Node(4, "Ross", 100));
		set.add(new Node(5, "Monica", 90));
		set.add(new Node(6, "Rachel", 60));
		set.add(new Node(7, "Joy", 60));
		set.add(new Node(8, "Denny", 90));
		set.add(new Node(9, "Jack", 70));
	}

	@Test
	public void testDescendingSet() {
		Set<Node> descendingSet = set.descendingSet();
		descendingSet.forEach(System.out::println);
	}

	@Test
	public void testSubSet() {
		Set<Node> setSet = set.subSet(new Node(2, "Kate", 80), new Node(7, "Joy", 60));
		setSet.forEach(System.out::println);
	}

	static class Node implements Comparable<Node> {
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
					", date=" + date +
					'}';
		}

		@Override
		public int compareTo(Node o) {
			if (this == o) return 0;

			if (this.score - o.score !=0 ) {
				return o.score - this.score;
			} else {
				return this.id - o.id;
			}
		}
	}

}
