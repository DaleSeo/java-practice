package seo.dale.practice.java.time;

import org.junit.Test;

import java.time.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * https://docs.oracle.com/javase/tutorial/datetime/iso/datetime.html
 * http://blog.eomdev.com/java/2016/04/01/%EC%9E%90%EB%B0%948%EC%9D%98-java.time-%ED%8C%A8%ED%82%A4%EC%A7%80.html
 */
public class LocalDateTimeTest {
    @Test
    public void testToString() {
        System.out.printf("now: %s%n", LocalDateTime.now());

        System.out.printf("Apr 15, 1994 @ 11:30am: %s%n",
                LocalDateTime.of(1994, Month.APRIL, 15, 11, 30));

        System.out.printf("now (from Instant): %s%n",
                LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));

        System.out.printf("6 months from now: %s%n",
                LocalDateTime.now().plusMonths(6));

        System.out.printf("6 months ago: %s%n",
                LocalDateTime.now().minusMonths(6));
    }

    @Test
    public void testPeriod() {
        LocalDate startTime = LocalDate.now();
        LocalDate endTime = startTime.plusYears(3).plusMonths(5).plusDays(12);
        Period period = Period.between(startTime, endTime);

        assertThat(period.getYears()).isEqualTo(3);
        assertThat(period.getMonths()).isEqualTo(5);
        assertThat(period.getDays()).isEqualTo(12);
    }

    @Test
    public void testDuration() {
        LocalTime startTime = LocalTime.now();
        LocalTime endTime = startTime.plusHours(3).plusMinutes(5).plusSeconds(12);
        Duration duration = Duration.between(startTime, endTime);

        assertThat(duration.getSeconds()).isEqualTo(11112);
    }

    @Test(expected = DateTimeException.class)
    public void mustThrowDateTimeExceptionForInvalidHourOfDay() {
        LocalTime.of(24, 35, 27);
        fail();
    }
}
