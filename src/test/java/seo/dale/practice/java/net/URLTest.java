package seo.dale.practice.java.net;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;

/**
 * http://docs.oracle.com/javase/tutorial/networking/urls/creatingUrls.html
 */
public class URLTest {

    /**
     * http://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
     */
    @Test
    public void testOpenStream() throws IOException {
        URL url = new URL("http://jsonplaceholder.typicode.com/posts/1");
        InputStream inputStream = url.openStream();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    @Test
    public void testAbsolute() throws MalformedURLException {
        URL absoluteUrl = new URL("http://jsonplaceholder.typicode.com/posts/1");
        System.out.println(absoluteUrl);
        assertEquals("http://jsonplaceholder.typicode.com/posts/1", absoluteUrl.toString());
    }

    @Test
    public void testRelative() throws MalformedURLException {
        URL baseUrl = new URL("http://jsonplaceholder.typicode.com");
        URL relativeUrl1 = new URL(baseUrl, "/posts");
        assertEquals("http://jsonplaceholder.typicode.com/posts", relativeUrl1.toString());
        URL relativeUrl2 = new URL(relativeUrl1, "/posts/1");
        assertEquals("http://jsonplaceholder.typicode.com/posts/1", relativeUrl2.toString());
        URL relativeUrl3 = new URL(relativeUrl2, "2");
        assertEquals("http://jsonplaceholder.typicode.com/posts/2", relativeUrl3.toString());
        URL relativeUrl4 = new URL(relativeUrl3, "#footer");
        assertEquals("http://jsonplaceholder.typicode.com/posts/2#footer", relativeUrl4.toString());
    }

    @Test
    public void testComponents() throws MalformedURLException {
        URL url = new URL("http", "example.com", 80, "/pages/page1.html");
        assertEquals("http://example.com:80/pages/page1.html", url.toString());
    }

    @Test
    public void testWithSpecialCharacters() throws MalformedURLException, URISyntaxException {
        URL url = new URL("http://example.com/hello%20world/");
        System.out.println(url);
        URI uri = new URI("http", "example.com", "/hello world", "");
        System.out.println(uri.toString());
        URL url2 = uri.toURL();
        System.out.println(url2);
    }

    /**
     *  http://docs.oracle.com/javase/tutorial/networking/urls/urlInfo.html
     */
    @Test
    public void testParse() throws MalformedURLException {
        URL aURL = new URL("http://example.com:80/docs/books/tutorial/index.html?name=networking#DOWNLOADING");

        System.out.println("protocol = " + aURL.getProtocol());
        System.out.println("authority = " + aURL.getAuthority());
        System.out.println("host = " + aURL.getHost());
        System.out.println("port = " + aURL.getPort());
        System.out.println("path = " + aURL.getPath());
        System.out.println("query = " + aURL.getQuery());
        System.out.println("file = " + aURL.getFile());
        System.out.println("ref = " + aURL.getRef());
    }

}
