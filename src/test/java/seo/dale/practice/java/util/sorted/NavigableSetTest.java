package seo.dale.practice.java.util.sorted;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://daleseo.github.io/2017/05/28/java-navigable-set/
 * http://www.geeksforgeeks.org/navigableset-java-examples/
 * http://tutorials.jenkov.com/java-collections/navigableset.html
 */
public class NavigableSetTest {

    private static final List<String> animals = Arrays.asList("Dog", "Cat", "Tiger", "Lion", "Elephant");

	private NavigableSet<String> animalSet;

    @Before
    public void setUp() {
        animalSet = new TreeSet<>(animals);
    }

    @Test
    public void testDescendingIterator() {
        Set<String> revAnimalSet = new TreeSet<>(Collections.reverseOrder());
        revAnimalSet.addAll(animalSet);

        for (String animal : revAnimalSet) {
            System.out.println(animal);
        }

        for (Iterator<String> iter = animalSet.descendingIterator(); iter.hasNext(); ) {
            System.out.println(iter.next());
        }
    }

    @Test
    public void testDescendingSet() {
        NavigableSet<String> revAnimalSet = animalSet.descendingSet();
        System.out.println("#animalSet: "  + animalSet);
        System.out.println("#revAnimalSet: "  + revAnimalSet);

        Set<String> expected = new TreeSet<>(Collections.reverseOrder());
        expected.addAll(animalSet);
        assertThat(revAnimalSet).isEqualTo(expected);
    }

    @Test
    public void testPoll() {
        String first = animalSet.first();
        System.out.println("#first: " + first);
        assertThat(first).isEqualTo("Cat");

        //
//        String first = animalSet.first();
//        animalSet.remove(first);

        String last = animalSet.pollLast();
        System.out.println("#last: " + last);
        assertThat(last).isEqualTo("Tiger");

        assertThat(animalSet).hasSize(3);
    }

    @Test
    public void testFloorCeilingLowerHigher() {
        // [Cat, Dog, E, Elephant, Lion, Tiger]

        String higher = animalSet.higher("Elephant");
        System.out.println("#higher: " + higher);

        String lower = animalSet.lower("Elephant");
        System.out.println("#lower: " + lower);

        String ceiling = animalSet.ceiling("Elephant");
        System.out.println("#ceiling: " + ceiling);

        String floor = animalSet.floor("Elephant");
        System.out.println("#floor: " + floor);
    }

}
