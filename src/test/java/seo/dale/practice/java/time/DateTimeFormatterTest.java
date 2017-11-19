package seo.dale.practice.java.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#patterns
 */
public class DateTimeFormatterTest {
    @Test
    public void testParse() {
        ZonedDateTime zdt = ZonedDateTime.now();
        String formattedStr = zdt.format(DateTimeFormatter.ISO_DATE_TIME);

        ZonedDateTime parseZdt = ZonedDateTime.parse(formattedStr, DateTimeFormatter.ISO_DATE_TIME);
        assertThat(parseZdt.isEqual(zdt)).isTrue();
    }

    @Test
    public void test() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
        LocalDateTime ldt = LocalDateTime.of(2017, Month.NOVEMBER, 18, 11, 7);
        assertThat(ldt.format(format)).isEqualTo("Nov 18 2017  11:07 AM");
    }
}
