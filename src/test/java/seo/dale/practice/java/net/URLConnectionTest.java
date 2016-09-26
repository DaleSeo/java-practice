package seo.dale.practice.java.net;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * http://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html
 */
public class URLConnectionTest {

    @Test
    public void testGetOutputStream() throws IOException {
        URL url = new URL("http://jsonplaceholder.typicode.com/posts");
        URLConnection urlConnection = url.openConnection();
        // If you invoke the method setDoOutput(true) on the URLConnection, it will always use the POST method.
        urlConnection.setDoOutput(true);
        try (OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream())) {
            writer.write("{title: 'foo', body: 'bar', userId: 1}");
            writer.flush();
        }

        try (Scanner scanner = new Scanner(urlConnection.getInputStream())) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

	@Test
    public void testGetInputStream() throws IOException {
        URL url = new URL("http://jsonplaceholder.typicode.com/posts/1");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

}
