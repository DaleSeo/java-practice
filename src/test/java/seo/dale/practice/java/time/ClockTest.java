package seo.dale.practice.java.time;

import org.junit.Test;

import java.time.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockTest {
    @Test
    public void testFixed() {
        ZoneId zoneId = ZoneId.of("America/Vancouver");
        Clock clock = Clock.fixed(Instant.EPOCH, zoneId);
        ZonedDateTime actual = ZonedDateTime.now(clock);
        ZonedDateTime expected = ZonedDateTime.ofInstant(Instant.EPOCH, zoneId);
        assertThat(actual.isEqual(expected)).isTrue();

        ZonedDateTime actual2 = ZonedDateTime.now(clock);
        assertThat(actual.isEqual(actual2)).isTrue();
    }

    @Test
    public void test() {
        Clock clock = Clock.systemUTC();
        ZonedDateTime actual = ZonedDateTime.now(clock);

        assertThat(actual.getZone()).isEqualTo(ZoneOffset.of("Z"));
    }
}
