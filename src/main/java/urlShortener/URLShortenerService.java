package urlShortener;

import java.net.URL;

import urlShortener.exceptions.URLShortenerException;

public interface URLShortenerService {
	
	ShortUrlStatistics statistics();
	
	ShortUrl convertToShortUrl(URL originalUrl) throws URLShortenerException;
	
	ShortUrl convertToShortUrl(URL originalUrl, UncheckedShortName shortName) throws URLShortenerException;

    URL getOriginalUrlFromShortName(UncheckedShortName shortName) throws URLShortenerException;
}
