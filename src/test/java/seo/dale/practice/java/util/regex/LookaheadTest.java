package seo.dale.practice.java.util.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class LookaheadTest {

    public static final String TEXT =
            "The history of apple computer\n" +
            "News for apple computer\n" +
            "The apple is the pomaceous fruit of the apple tree\n" +
            "apple computer is not the apple";

    @Test
    public void test1() {
        Pattern pattern = Pattern.compile("apple");
        Matcher matcher = pattern.matcher(TEXT);
        int cnt = 0;
        while (matcher.find()) {
            System.out.println(matcher.group());
            cnt++;
        }
        assertEquals(6, cnt);
    }

    @Test
    public void test2() {
        Pattern pattern =Pattern.compile("apple ((\\w+)?)");
        Matcher matcher = pattern.matcher(TEXT);
        while (matcher.find()) {
            if (matcher.group(1).equals("computer")) {
                continue;
            }
            System.out.println(matcher.group(0));
        }
    }

    // 뒤에 " computer"가 따라오는 apple 검색
	@Test
	public void testPositiveLookahead() {
		// Pattern pattern =Pattern.compile("apple(?=\\scomputer)");
		Pattern pattern =Pattern.compile("apple(?=\\scomputer) computer");
		Matcher matcher = pattern.matcher(TEXT);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	// 뒤에 " computer"가 따라오는 않는 apple 검색
	@Test
	public void testNegativeLookahead() {
		Pattern pattern =Pattern.compile("apple(?!\\scomputer)");
		Matcher matcher = pattern.matcher(TEXT);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	// 같은 문자가 2번 이상 반복되지 않는 패턴만 검
	@Test
	public void testNegativeLookahead2() {
		Pattern pattern =Pattern.compile("(.)(?!\\1)");
		Matcher matcher = pattern.matcher("goooo");
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	// 앞에 " apple"이 있는 computer 검색
	@Test
	public void testPositiveLookbehind() {
		Pattern pattern =Pattern.compile("(?<=apple\\s)computer");
		Matcher matcher = pattern.matcher(TEXT);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
