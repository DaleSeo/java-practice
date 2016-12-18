package seo.dale.practice.java.util.optional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.fail;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by Dale on 2016-11-11.
 */
public class OptionalTest {

    @Test
    public void testEmpty() {
        Optional<Soundcard> sc = Optional.empty();
        System.out.println(sc);
        assertThat(sc.isPresent()).isFalse();
    }

    @Test
    public void testOf() {
        Soundcard soundcard = new Soundcard();
        Optional<Soundcard> sc = Optional.of(soundcard);
        System.out.println(sc);
        assertThat(sc.isPresent()).isTrue();
    }

    @Test(expected = NullPointerException.class)
    public void testOfThrowsException() {
        Optional<Soundcard> sc = Optional.of(null);
        fail();
    }

    @Test
    public void testOfNullable() {
        Soundcard soundcard = null;
        Optional<Soundcard> sc = Optional.ofNullable(soundcard);
        System.out.println(sc);
        assertThat(sc.isPresent()).isFalse();
    }

    @Test
    public void testIfPresent() {
        Soundcard soundcard = new Soundcard();
        Optional<Soundcard> sc = Optional.of(soundcard);
        sc.ifPresent(System.out::println);
    }

    @Test
    public void testOrElse() {
        Soundcard defaultSoucdcard = new Soundcard();
        Optional<Soundcard> maybeSoundcard = Optional.empty();
        Soundcard soundcard = maybeSoundcard.orElse(defaultSoucdcard);
        System.out.println(soundcard);
        assertThat(soundcard).isEqualTo(defaultSoucdcard);
    }

    @Test(expected = IllegalStateException.class)
    public void testOrElseThrow() {
        Optional<Soundcard> maybeSoundcard = Optional.empty();
        maybeSoundcard.orElseThrow(IllegalStateException::new);
        fail();
    }

    @Test
    public void testFilter() {
        Optional<USB> maybeUSB = Optional.of(new USB("3.0"));
        maybeUSB.filter(usb -> "3.0".equals(usb.getVersion()))
                .ifPresent(System.out::print);
    }

    @Test
    public void testMap() {
        Optional<USB> USB = Optional.of(new USB("3.0"));
        Soundcard soucdcard = new Soundcard(USB);
        Optional<Soundcard> maybeSoundcard = Optional.of(soucdcard);

        maybeSoundcard.map(Soundcard::getUsb)
                .filter(usb -> "3.0".equals(usb.get().getVersion()))
                .ifPresent(System.out::print);
    }

    @Test
    public void testFlatMap() {
        Optional<USB> usb = Optional.of(new USB("3.0"));
        Optional<Soundcard> soucdcard = Optional.of(new Soundcard(usb));
        Optional<Computer> computer = Optional.of(new Computer(soucdcard));

        String version = computer.flatMap(Computer::getSoundcard)
                .flatMap(Soundcard::getUsb)
                .map(USB::getVersion)
                .orElse("UNKNOWN");
        System.out.println(version);
    }

}