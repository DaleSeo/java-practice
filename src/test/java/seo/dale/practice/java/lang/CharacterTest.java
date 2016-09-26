package seo.dale.practice.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CharacterTest {

    @Test
    public void test() {
        assertTrue(Character.isLetter('a'));
        assertTrue(Character.isDigit('1'));
        assertTrue(Character.isLetterOrDigit('a'));
        assertTrue(Character.isLetterOrDigit('1'));
        assertTrue(Character.isLowerCase('a'));
        assertTrue(Character.isUpperCase('A'));
    }

}
