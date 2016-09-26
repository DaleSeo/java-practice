package seo.dale.practice.java.io;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class LineNumberReaderTest {

    @Test
    public void test() throws Exception {
        InputStream is = new ByteArrayInputStream("Line Number Reader.\nLet's Test!".getBytes());
        LineNumberReader reader = new LineNumberReader(new BufferedReader(new InputStreamReader(is)));

        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(reader.getLineNumber() + " : "+ line + "\n");
        }

        String output = builder.toString();
        System.out.println(output);
        assertEquals("1 : Line Number Reader.\n2 : Let's Test!\n", output);
    }

}
