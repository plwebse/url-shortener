package urlShortener;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import urlShortener.exceptions.URLShortenerException;


public class URLShortenerServiceImpl implements URLShortenerService {

	private URL baseUrl = null;
	
	public URLShortenerServiceImpl(URL baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public ShortUrl convertToShortUrl(URL orginalUrl) throws URLShortenerException  {
		return new ShortUrl(orginalUrl, generateShortUrl(orginalUrl));
	}
	
	public ShortUrl convertToShortUrl(URL orginalUrl, UncheckedShortName shortName) throws URLShortenerException  {
		return new ShortUrl(orginalUrl, generateShortUrl(orginalUrl, shortName.toString()));
	}
	
	private URL generateShortUrl(URL orginalUrl) {
		return generateShortUrl(orginalUrl, generateAutoMatikShortname(orginalUrl));
	}

	private URL generateShortUrl(URL orginalUrl, String shortname) {
		try {
			return new ShortUrl(orginalUrl, new URL(baseUrl, shortname)).url();
		} catch (MalformedURLException e) { // TODO check
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private String generateAutoMatikShortname(URL orginalUrl){
		String tmp = orginalUrl.toString();
		String res = "";
		final String alphabet = "0123456789abcdefghijklmnopqrstuvåäö";
	    final int N = alphabet.length();

	    Random r = new Random();

	    for (int i = 0; i < 10; i++) {
	    	res += alphabet.charAt(r.nextInt(N));	        
	    }
		
		return res;
	}

	
	
	public ShortUrlStatistics statistics() {		
		return null;
	}
	

}
