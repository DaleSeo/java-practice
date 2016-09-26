package seo.dale.practice.java.lang;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BitOperatorTest {

    @Test
    public void testSiftLeft() {
        long intBinaryMaxIn32Bits = (1L << 32) - 1; // 4294967295
        assertEquals((long) Math.pow(2, 32) - 1, intBinaryMaxIn32Bits);
        String binaryString = Long.toBinaryString(intBinaryMaxIn32Bits);
        assertEquals("11111111111111111111111111111111", binaryString);
    }

}
