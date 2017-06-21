package seo.dale.practice.java.util.collections;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://stackoverflow.com/questions/223918/iterating-through-a-collection-avoiding-concurrentmodificationexception-when-re
 */
public class RemovingElements {

    public static void main(String[] args) {
        List<Character> letters = new ArrayList<>();
        letters.addAll(Arrays.asList('A', 'B', '1', '2', 'C', 'D', '3', 'E', '4', '5'));

//        for (Character letter : letters) {
//            if (Character.isDigit(letter)) {
//                System.out.println(letter + " is a digit.");
//                letters.remove(letter);
//            }
//        }

//        for (int i = 0; i < letters.size(); i++) {
//            Character letter = letters.get(i);
//            if (Character.isDigit(letter)) {
//                System.out.println(letter + " is a digit.");
//                letters.remove(i);
//            }
//        }
//        System.out.println(letters);

        List<Character> alphabets = letters.stream()
                .filter(Character::isAlphabetic)
                .collect(Collectors.toList());

        System.out.println(alphabets);

        for (Iterator<Character> iter = letters.iterator(); iter.hasNext(); ) {
            Character letter = iter.next();
            if (Character.isDigit(letter)) {
                System.out.println(letter + " is a digit.");
                iter.remove();
            }
        }

        System.out.println(letters);

        letters.removeIf(Character::isDigit);

        System.out.println(letters);
    }


}
