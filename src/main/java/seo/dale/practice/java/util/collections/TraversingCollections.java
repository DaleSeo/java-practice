package seo.dale.practice.java.util.collections;

import java.util.*;

/**
 * http://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
 */
public class TraversingCollections {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Coconut", "Lemon", "Melon");

        System.out.println("- 1. Stream -");

        fruits.stream().forEach(System.out::println);

        System.out.println("- 2. Enhanced For Loop -");

        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        System.out.println("- 3. Iterator -");

        for (Iterator<String> iter = fruits.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next());
        }

        System.out.println("- 4. Traditional For Loop -");

        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }
    }

}
