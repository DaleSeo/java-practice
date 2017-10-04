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

    public String getItem() {
        return item;
    }

    public int getFreq() {
        return freq;
    }

}
