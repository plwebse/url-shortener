package urlShortener;

import java.net.MalformedURLException;
import java.net.URL;


import urlShortener.exceptions.URLShortenerException;


public class URLShortenerServiceImpl implements URLShortenerService {

	private URL baseUrl = null;
	
	public URLShortenerServiceImpl(URL baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public ShortUrl convertToShortUrl(URL orginalUrl) throws URLShortenerException  {
		return new ShortUrl(generateShortUrl(orginalUrl));
	}
	
	public ShortUrl convertToShortUrl(URL orginalUrl, UncheckedShortName shortName) throws URLShortenerException  {
		return new ShortUrl(generateShortUrl(orginalUrl, shortName.toString()));
	}

	public ShortUrlStatistics statistics() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String generateAutoMatikShortname(){
		return null;
	}
	
	private URL generateShortUrl(URL orginalUrl) {
		return generateShortUrl(orginalUrl, generateAutoMatikShortname());
	}
	
	private String generateShortName(){
		return "";
	}
	
	private URL generateShortUrl(URL orginalUrl, String shortname) {
		try {
			return new ShortUrl(new URL(orginalUrl, shortname)).url();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
