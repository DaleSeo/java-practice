package seo.dale.practice.java.util.regex;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PatternTest {

	/**
	 * @gmail.com 으로 끝나는 문자열 패턴이 포함되어 있는지 체크
     */
	@Test
	public void testMatches() {
		String regex = ".*@gmail.com";
		assertTrue(Pattern.matches(regex, "dale.seo@gmail.com"));
		assertFalse(Pattern.matches(regex, "dale_seo@daum.net"));
	}

	@Test
	public void test() {
		String test = "123ABC";
		System.out.println(test);
		assertTrue(Pattern.matches(wildcardToRegex("1*"), test));
		assertTrue(Pattern.matches(wildcardToRegex("?2*"), test));
		assertFalse(Pattern.matches(wildcardToRegex("??2*"), test));
		assertTrue(Pattern.matches(wildcardToRegex("*A*"), test));
		assertFalse(Pattern.matches(wildcardToRegex("*Z*"), test));
		assertTrue(Pattern.matches(wildcardToRegex("123*"), test));
		assertFalse(Pattern.matches(wildcardToRegex("123"), test));
		assertTrue(Pattern.matches(wildcardToRegex("*ABC"), test));
		assertFalse(Pattern.matches(wildcardToRegex("*abc"), test));
		assertFalse(Pattern.matches(wildcardToRegex("ABC*"), test));
		assertFalse(Pattern.matches(wildcardToRegex("*1.2.3.4*"), test));
		
		assertTrue(Pattern.matches(wildcardToRegex("127.0.0.*"), "127.0.0.100"));
	}

	public static String wildcardToRegex(String wildcard) {
		StringBuilder sb = new StringBuilder(wildcard.length());
		sb.append('^');
		for (int i = 0; i < wildcard.length(); i++) {
			char ch = wildcard.charAt(i);
			switch (ch) {
			// multiple words
			case '*':
				sb.append(".*");
				break;
			// a single word
			case '?':
				sb.append(".");
				break;
			// escape special regexp-characters
            case '(': case ')': case '[': case ']': case '$':
            case '^': case '.': case '{': case '}': case '|':
            case '\\':
                sb.append("\\");
                sb.append(ch);
                break;
            // normal characters
            default:
            	sb.append(ch);
            	break;
			}
		}
		sb.append('$');
		String regex = sb.toString();
		
		System.out.println(wildcard + " ===> " + regex);
		return regex;
	}
	
}
