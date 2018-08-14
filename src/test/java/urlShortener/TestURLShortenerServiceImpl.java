package urlShortener;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import urlShortener.exceptions.URLShortenerException;

public class TestURLShortenerServiceImpl {

    URLShortenerService urlShortenerService;

	@Before
	public void setUp() throws Exception {
        urlShortenerService = new URLShortenerServiceImpl(new URL("http://plweb.se/"));
    }

	@After
	public void tearDown() {
        urlShortenerService = null;
	}

	@Test
	public void basicTest() throws MalformedURLException, URLShortenerException {
		assertEquals(new URL("http://plweb.se/binarytime"), urlShortenerService.convertToShortUrl(new URL("http://binaryti.me/all-about-binary-time"), new UncheckedShortName("binarytime")).url());

	}

	@Test(expected = URLShortenerException.class)
    public void testBadWords() throws MalformedURLException, URLShortenerException {
        assertEquals(new URL("http://plweb.se/binarytime"), urlShortenerService.convertToShortUrl(new URL("http://binaryti.me/all-about-binary-time-xxx"), new UncheckedShortName("binarytimexxx")).url());
    }

    @Test(expected = URLShortenerException.class)
    public void testNonDublicate() throws MalformedURLException, URLShortenerException {
	    assertNotNull(urlShortenerService.convertToShortUrl(
	            new URL("http://binaryti.me/all-about-binary-time"),
                new UncheckedShortName("binarytime")));
        assertNotNull(urlShortenerService.convertToShortUrl(
                new URL("http://binaryti.me/all-about-binary-time"),
                new UncheckedShortName("binarytime")));
    }

    @Test
    public void testGetOriginalUrl() throws MalformedURLException, URLShortenerException {
	    UncheckedShortName uncheckedShortName = new UncheckedShortName("binarytime");
        URL originalUrl = new URL( "http://binaryti.me/all-about-binary-time");

        urlShortenerService.convertToShortUrl(
                originalUrl,
                uncheckedShortName);

        assertEquals(originalUrl, urlShortenerService.getOriginalUrlFromShortName(uncheckedShortName));
    }

}
