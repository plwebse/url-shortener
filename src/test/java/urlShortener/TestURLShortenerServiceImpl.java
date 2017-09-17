package urlShortener;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import urlShortener.URLShortenerServiceImpl;
import urlShortener.exceptions.URLShortenerException;

public class TestURLShortenerServiceImpl {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws MalformedURLException, URLShortenerException {
		URLShortenerService urlShortenerService = new URLShortenerServiceImpl(new URL("http://plweb.se/"));
		assertEquals(new URL("http://plweb.se/binarytime"), 
				urlShortenerService.convertToShortUrl(new URL("http://binaryti.me/all-about-binary-time"), 
				new UncheckedShortName("binarytime")).url()
		);
		
	}

}
