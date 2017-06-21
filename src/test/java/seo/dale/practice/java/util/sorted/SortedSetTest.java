package seo.dale.practice.java.util.sorted;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * https://daleseo.github.io/2017/05/21/java-sorted-set/
 * http://www.geeksforgeeks.org/sortedset-java-examples/
 * http://docs.oracle.com/javase/tutorial/collections/interfaces/sorted-set.html
 */
public class SortedSetTest {

    private static final List<String> animals = Arrays.asList("Dog", "Cat", "Tiger", "Lion", "Elephant");

    private SortedSet<String> animalSet;

    @Before
    public void setUp() {
        animalSet = new TreeSet<>(animals);
    }

    @Test
    public void testHeadSet() {
        Set<String> headSet = animalSet.headSet("Elephant");
        System.out.println("#headSet: " + headSet);
    }

    @Test
    public void testTailSet() {
        Set<String> tailSet = animalSet.tailSet("Elephant");
        System.out.println("#tailSet: " + tailSet);
    }

    @Test
    public void testSubSet() {
        Set<String> subSet = animalSet.subSet("Dog", "Lion");
        System.out.println("#subSet: " + subSet);
    }


    @Test
    public void testFirst() {
        String first = animalSet.first();
        System.out.println("#first: " + first);
    }

    @Test
    public void testLast() {
        String last = animalSet.last();
        System.out.println("#last: " + last);
    }

    @Test
    public void testComparator() {
        Comparator<? super String> comparator = animalSet.comparator();
        System.out.println("#comparator : " + comparator);

        SortedSet<String> anotherSet = new TreeSet<>(Collections.reverseOrder());
        Comparator<? super String> anotherComparator = anotherSet.comparator();
        System.out.println("#anotherComparator : " + anotherComparator);
    }

}
