package seo.dale.practice.java.util;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class HashSetTest {

	@Test
	public void testHashSetWithString() {
		Set<String> set = new HashSet<String>();
		set.add("aaaa");
		set.add("baaa");
		set.add("aaaa");
		set.add("baaa");
		System.out.println(set);
		assertEquals(set.size(), 2);
	}
	
	@Test
	public void testHashSetWithNode() {
		Set<Node> set = new HashSet<Node>();
		set.add(new Node("aaaa", 0));
		set.add(new Node("baaa", 1));
		set.add(new Node("aaaa", 0));
		set.add(new Node("baaa", 1));
		System.out.println(set);
		assertEquals(set.size(), 2);
	}
	
	public class Node {
		
		public String data;
		public int depth;
		
		public Node(String data, int depth) {
			this.data = data;
			this.depth = depth;
		}
		
		@Override
		public int hashCode() {
			return data.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			return data.equals(((Node) obj).data);
		}
		
	}

}
