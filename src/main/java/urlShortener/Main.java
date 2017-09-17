package urlShortener;

import java.net.MalformedURLException;
import java.net.URL;

import urlShortener.exceptions.URLShortenerException;

public class Main {

	public static void main(String[] args) throws MalformedURLException, URLShortenerException {
		System.out.println("hello");
		
		URLShortenerService urlShortenerService = new URLShortenerServiceImpl(new URL("http://plweb.se"));
		urlShortenerService.convertToShortUrl(new URL("http://binaryti.me/all-about-binary-time"), new UncheckedShortName("binarytime"));
		
	}

}
