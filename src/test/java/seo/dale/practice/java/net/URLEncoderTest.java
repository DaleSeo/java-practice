package seo.dale.practice.java.net;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderTest {

	@Test
	public void test() {
		String urlPrefix = "http://www.example.com/test.php?ids=";
		String value = "1|2";

		String url = urlPrefix + value;

		System.out.println(url);

		String encodedUrl = null;
		try {
			encodedUrl = urlPrefix + URLEncoder.encode(value, "US-ASCII");
			System.out.println(encodedUrl);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			URI uri = new URI(url);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			URI encodedUri = new URI(encodedUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String decodedUrl = URLDecoder.decode(encodedUrl, "US-ASCII");
			System.out.println(decodedUrl);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
