package seo.dale.practice.java.util.optional;

import java.util.Optional;

/**
 * Created by Dale on 2016-11-11.
 */
public class Computer {

    private Optional<Soundcard> soundcard;

    public Computer(Optional<Soundcard> soundcard) {
        this.soundcard = soundcard;
    }

    public Optional<Soundcard> getSoundcard() {
        return soundcard;
    }

}
