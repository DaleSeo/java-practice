package seo.dale.practice.java.net;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import static org.junit.Assert.assertEquals;

public class URITest {

	/**
	 * If this factory method is used, An IllegalException will be thrown instead of an URISyntaxException.
	 * Unless you construct URI with user inputs, it is a better choice than the constructors.
	 */
	@Test
	public void testFactoryMethod() {
		URI uri = URI.create("https://user:pswd@www.host.com:8080/file;p=1?q=2#fragment");
		System.out.println("# testSingleConstructor() : " + uri);
		assertEquals("https://user:pswd@www.host.com:8080/file;p=1?q=2#fragment", uri.toString());
	}

	@Test
	public void testSingleConstructor() throws URISyntaxException {
		URI uri = new URI("https://user:pswd@www.host.com:8080/file;p=1?q=2#fragment");
		System.out.println("# testSingleConstructor() : " + uri);
		assertEquals("https://user:pswd@www.host.com:8080/file;p=1?q=2#fragment", uri.toString());
	}
	
	@Test
	public void testMultiConstructor() throws URISyntaxException {
		URI uri = new URI("https", "user:pswd", "www.host.com", 8080, "/file;p=1", "q=2", "fragment");
		System.out.println("# testMultiConstructor() : " + uri);
		assertEquals("https://user:pswd@www.host.com:8080/file;p=1?q=2#fragment", uri.toString());
	}
	
	@Test
	public void testMultiConstructorSupportingEncoding() throws URISyntaxException {
		URI uri = new URI("https", "user:pswd", "www.host.com", 8080, "/file;p=1", "query=A B&no=1", "fragment");
		System.out.println("# testMultiConstructor() : " + uri);
		assertEquals("https://user:pswd@www.host.com:8080/file;p=1?query=A%20B&no=1#fragment", uri.toString());
		assertEquals("query=A B&no=1", uri.getQuery());
		assertEquals("query=A%20B&no=1", uri.getRawQuery()); 
		// query에서는 space가 +로 인코딩되야 하는데 %20으로 인코딩 되었음. 따라서 생성자에 인코딩을 맡기는 건 위험함.
	}
	
	@Test(expected=URISyntaxException.class)
	public void testThorwURISyntaxException() throws URISyntaxException {
		URI uri = new URI("http://jsonplaceholder.typicode.com/users?query=a&b 한글");
		System.out.println("# testThorwURISyntaxException() : " + uri.toString());
	}
	
	@Test
	public void testWithEncoding() throws URISyntaxException, UnsupportedEncodingException {
		String urlStr1 = "http://jsonplaceholder.typicode.com/users?query=";
		String urlStr2 = URLEncoder.encode("a&b 한글", "UTF-8"); // & -> %26, space -> +, Korean -> Unicode
		URI uri = new URI(urlStr1 + urlStr2);
		System.out.println("# testWithEncoding() : " + uri);
		assertEquals("http://jsonplaceholder.typicode.com/users?query=a%26b+%ED%95%9C%EA%B8%80", uri.toString());
		assertEquals("/users", uri.getPath());
		assertEquals("query=a&b+한글", uri.getQuery()); // space가 왜 +로 나오는지 모르겠음 ㅠㅠ
		assertEquals("query=a%26b+%ED%95%9C%EA%B8%80", uri.getRawQuery());
	}

}