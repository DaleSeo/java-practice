package seo.dale.practice.java.util.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RemovingElements {

    public static void main(String[] args) {
        Collection<String> fruits = new ArrayList<>();
        fruits.addAll(Arrays.asList("Apple", "Banana", "Coconut", "Lemon", "Melon", "Orange", "Strawberry"));
//
//        System.out.println("---");
//        fruits.stream().forEach(fruit -> System.out.println(fruit));

        System.out.println("---");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

//        System.out.println("---");
//        for (Iterator<String> iter = fruits.iterator(); iter.hasNext(); ) {
//            // System.out.println(iter.next());
//            String fruit = iter.next();
//            if (fruit.length() > 5) {
//                iter.remove();
//            }
//        }
//        System.out.println("#fruits: " + fruits);

        System.out.println("---");
        fruits.stream()
                .filter(fruit -> fruit.length() <= 5)
                .forEach(fruit -> System.out.println(fruit));

        System.out.println("---");
        List<String> fruitList = (List) fruits;
        for (int i = 0; i < fruitList.size(); i++) {
            String fruit = fruitList.get(i);
            if (fruit.length() > 5) {
                fruitList.remove(fruit);
                System.out.println("delete " + i + ":" + fruit);
            }
        }
        System.out.println("#fruitList: " + fruitList);
    }


}
