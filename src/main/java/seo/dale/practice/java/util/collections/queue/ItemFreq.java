package seo.dale.practice.java.util.collections.queue;

import lombok.Data;

@Data
public class ItemFreq {

    String item;
    int freq;

    public ItemFreq(String item, int freq) {
        this.item = item;
        this.freq = freq;
    }

}
