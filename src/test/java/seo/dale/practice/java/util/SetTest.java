package seo.dale.practice.java.util;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SetTest {

    @Test
    public void testAdd() {
        final Set<Person> people = new HashSet<>();

        final Person person1 = new Person("Alice", 28);
        final Person person2 = new Person("Bob", 30);
        final Person person3 = new Person("Charlie", 22);

        final boolean person1Added = people.add(person1);
        final boolean person2Added = people.add(person2);
        final boolean person3Added = people.add(person3);

        assertTrue(person1Added && person2Added && person3Added);

        final Person person1Again = new Person("Alice", 28);;

        final boolean person1AgainAdded = people.add(person1Again);

        assertFalse(person1AgainAdded);
        assertEquals(3, people.size());
    }

	/**
	 * The intersection of the two sets.
	 */
	@Test
	public void testRetainAll() {
	    Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
		Set<Integer> setB = new HashSet<>(Arrays.asList(9, 8, 7, 6, 5, 4, 3));
	    setA.retainAll(setB);
	    Set<Integer> intersection = new HashSet<>(Arrays.asList(3, 4, 5));
	    assertEquals(setA, intersection);
    }

	/**
	 * The union of the two sets.
	 */
	@Test
	public void testAddAll() {
	    Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
	    Set<Integer> setB = new HashSet<>(Arrays.asList(9, 8, 7, 6, 5, 4, 3));
	    setA.addAll(setB);
	    Set<Integer> union = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	    assertEquals(setA, union);
    }

	/**
	 * The difference of the two sets.
	 */
	@Test
	public void testRemoveAll() {
		Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
		Set<Integer> setB = new HashSet<>(Arrays.asList(9, 8, 7, 6, 5, 4, 3));
		setA.removeAll(setB);
		Set<Integer> union = new HashSet<>(Arrays.asList(1, 2));
		assertEquals(setA, union);
	}

}

class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }

        Person other = (Person) obj;
        if (this.name.equals(other.name) && this.age == other.age) {
            return true;
        }
        return false;
    }

}