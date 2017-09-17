package urlShortener;

import java.net.URL;


import urlShortener.exceptions.URLShortenerException;

public interface URLShortenerService {
	
	public ShortUrlStatistics statistics(); 
	
	public ShortUrl convertToShortUrl(URL orginalUrl) throws URLShortenerException;
	
	public ShortUrl convertToShortUrl(URL orginalUrl, UncheckedShortName shortName) throws URLShortenerException;
}
