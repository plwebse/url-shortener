package urlShortener;


import java.net.MalformedURLException;
import java.net.URL;


import urlShortener.exceptions.URLShortenerException;

public class Main {

    public static void main(String[] args) throws MalformedURLException, URLShortenerException {

        URLShortenerService urlShortenerService = new URLShortenerServiceImpl(new URL("http://plweb.se"));
        urlShortenerService.convertToShortUrl(new URL("http://binaryti.me/all-about-binary-time"), new UncheckedShortName("binarytime"));
        ShortUrl shortUrl = urlShortenerService.convertToShortUrl(new URL("http://binaryti.me/all-about-binary-time"));
        System.out.println(shortUrl);

    }

}
