package seo.dale.practice.java.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class ByteArrayStreamTest {

    @Test
    public void test() throws IOException {
        byte[] inputArray = {'a', 'b', 'c', 'd', 'e'};
        byte[] ouputArray;

        ByteArrayInputStream in = new ByteArrayInputStream(inputArray);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int b;
        while((b = in.read()) != -1) {
            out.write(b);
        }
        ouputArray = out.toByteArray();

        System.out.println(Arrays.toString(ouputArray));
        assertArrayEquals(inputArray, ouputArray);
    }

}
