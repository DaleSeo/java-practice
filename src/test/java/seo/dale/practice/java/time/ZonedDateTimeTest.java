package seo.dale.practice.java.time;

import org.junit.Test;

import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class ZonedDateTimeTest {
    private ZonedDateTime utcDateTime = ZonedDateTime.of(2017, 11, 17, 23, 32, 55, 0, ZoneId.of("UTC"));
    private ZonedDateTime seoulDateTime = ZonedDateTime.of(2017, 11, 17, 23, 32, 55, 0, ZoneId.of("Asia/Seoul"));

    @Test
    public void testGetOffset() {
        assertThat(utcDateTime.getOffset()).hasToString("Z");
        assertThat(seoulDateTime.getOffset()).hasToString("+09:00");
    }

    @Test
    public void testWith() {
        ZonedDateTime dateTimeCopy = utcDateTime
                .withYear(1970)
                .withMonth(1)
                .withDayOfMonth(1);

        assertThat(dateTimeCopy.getYear()).isEqualTo(1970);
        assertThat(dateTimeCopy.getMonth()).isEqualTo(Month.JANUARY);
        assertThat(dateTimeCopy.getDayOfMonth()).isEqualTo(1);
        assertThat(utcDateTime.getYear()).isNotEqualTo(1970);
    }

    @Test
    public void testIs() {
        assertThat(seoulDateTime.isBefore(utcDateTime)).isTrue();
        assertThat(utcDateTime.isAfter(seoulDateTime)).isTrue();
        assertThat(seoulDateTime.plusHours(9).isEqual(utcDateTime)).isTrue();
    }

    @Test
    public void testUntil() {
        assertThat(seoulDateTime.until(utcDateTime, ChronoUnit.HOURS)).isEqualTo(9);
        assertThat(ChronoUnit.HOURS.between(seoulDateTime, utcDateTime)).isEqualTo(9);
    }

    @Test
    public void testFormat() {
        assertThat(utcDateTime.format(DateTimeFormatter.ISO_DATE)).isEqualTo("2017-11-17Z");
        assertThat(utcDateTime.format(DateTimeFormatter.ISO_TIME)).isEqualTo("23:32:55Z");
        assertThat(seoulDateTime.format(DateTimeFormatter.ISO_DATE)).isEqualTo("2017-11-17+09:00");
        assertThat(seoulDateTime.format(DateTimeFormatter.ISO_TIME)).isEqualTo("23:32:55+09:00");
    }
}
