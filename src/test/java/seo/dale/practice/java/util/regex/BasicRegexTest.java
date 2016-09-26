package seo.dale.practice.java.util.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

/**
 * Concatenation, Repetition, Alternation, Negation
 */
public class BasicRegexTest {

    public static final String TEXT = "Splitting a string, it's as easy as 1 2 33!  Right?";

    @Test
    public void testConcatenation() {
        Pattern pattern = Pattern.compile("it");
        Matcher matcher = pattern.matcher(TEXT);

        int cnt = 0;
        String[] matches = {"it", "it"};

        while (matcher.find()) {
            assertEquals(matches[cnt], matcher.group());
            cnt++;
        }

        assertEquals(matches.length, cnt);
    }

    @Test
    public void testRepetitionOneOrMore() {
        Pattern pattern = Pattern.compile("it+");
        Matcher matcher = pattern.matcher(TEXT);

        int cnt = 0;
        String[] matches = {"itt", "it"};

        while (matcher.find()) {
            assertEquals(matches[cnt], matcher.group());
            cnt++;
        }

        assertEquals(matches.length, cnt);;
    }

    @Test
    public void testRepetitionZeroOrMore() {
        Pattern pattern = Pattern.compile("it*");
        Matcher matcher = pattern.matcher(TEXT);

        int cnt = 0;
        String[] matches = {"itt", "i", "i", "it", "i"};

        while (matcher.find()) {
            assertEquals(matches[cnt], matcher.group());
            cnt++;
        }

        assertEquals(matches.length, cnt);
    }

    @Test
    public void testAlternation() {
        Pattern pattern = Pattern.compile("it|st");
        Matcher matcher = pattern.matcher(TEXT);

        int cnt = 0;
        String[] matches = {"it", "st", "it"};

        while (matcher.find()) {
            assertEquals(matches[cnt], matcher.group());
            cnt++;
        }

        assertEquals(matches.length, cnt);
    }

    @Test
    public void testCharacterClasses() {
        // Pattern pattern = Pattern.compile("[123]");
        Pattern pattern = Pattern.compile("[1-3]"); // range
        Matcher matcher = pattern.matcher(TEXT);

        int cnt = 0;
        String[] matches = {"1", "2", "3", "3"};

        while (matcher.find()) {
            assertEquals(matches[cnt], matcher.group());
            cnt++;
        }

        assertEquals(matches.length, cnt);
    }

    @Test
    public void testNegation() {
        Pattern pattern = Pattern.compile("[^a-z1-3 ]"); // range
        Matcher matcher = pattern.matcher(TEXT);

        int cnt = 0;
        String[] matches = {"S", ",", "'", "!", "R", "?"};

        while (matcher.find()) {
            assertEquals(matches[cnt], matcher.group());
            cnt++;
        }

        assertEquals(matches.length, cnt);
    }

}
