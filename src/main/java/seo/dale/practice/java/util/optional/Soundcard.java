package seo.dale.practice.java.util.optional;

import java.util.Optional;

/**
 * Created by Dale on 2016-11-11.
 */
public class Soundcard {
    private Optional<USB> usb;

    public Soundcard() {
    }

    public Soundcard(Optional<USB> usb) {
        this.usb = usb;
    }

    public Optional<USB> getUsb() {
        return usb;
    }
}
