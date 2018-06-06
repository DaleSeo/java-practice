package seo.dale.practice.java.util.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class GroupTest {
    @Test
    public void test() {
        Pattern pattern = Pattern.compile("^interval-chunk/(\\d{4}\\/\\d{2}\\/\\d{2}\\/\\d{2}\\/\\d{2}00)-\\d{2}00$");
        String objectPrefix = "interval-chunk/2018/05/27/14/2800-3000";
        Matcher matcher = pattern.matcher(objectPrefix);
        if (matcher.matches()) {
            assertThat(matcher.group()).isEqualTo("interval-chunk/2018/05/27/14/2800-3000");
            assertThat(matcher.group(1)).isEqualTo("2018/05/27/14/2800");
        } else {
            fail();
        }
    }
}
