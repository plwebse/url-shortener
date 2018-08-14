package urlShortener;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import urlShortener.exceptions.URLShortenerException;
import java.sql.*;

public class URLShortenerServiceImpl implements URLShortenerService {

	private URL baseUrl = null;
	private Connection conn = null;
	private final static String driver = "org.h2.Driver";
	private final static String url = "jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1";
	private List<ShortUrl> shortUrls = new ArrayList<>();

	public URLShortenerServiceImpl(URL baseUrl) {
		this.baseUrl = baseUrl; 
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"","");
		} catch (ClassNotFoundException | SQLException e ) {
			e.printStackTrace();
		}
	}
	
	public ShortUrl convertToShortUrl(URL originalUrl) throws URLShortenerException  {
        return addToListIfUniqe(new ShortUrl(originalUrl, generateShortUrl(originalUrl)));
	}
	
	public ShortUrl convertToShortUrl(URL originalUrl, UncheckedShortName shortName) throws URLShortenerException  {
        return addToListIfUniqe(new ShortUrl(originalUrl, generateShortUrl(originalUrl, shortName.toString())));
	}

    public URL getOriginalUrlFromShortName(UncheckedShortName shortName) {
	    URL shortUrl = getShortUrlFromShortName(shortName);
	    Optional<ShortUrl> optionalShortUrl = shortUrls.stream().filter(s -> s.url().equals(shortUrl)).findFirst();

	    if(optionalShortUrl.isPresent()){
			return optionalShortUrl.get().originalUrl();
        }

        return null;
	}

	private URL generateShortUrl(URL originalUrl) {
		return generateShortUrl(originalUrl, generateAutomaticShortname());
	}

	private URL generateShortUrl(URL originalUrl, String shortname) {
		try {
			return new ShortUrl(originalUrl, new URL(baseUrl, shortname)).url();
		} catch (MalformedURLException e) { // TODO check
			e.printStackTrace();
		}
		return null;
	}
	
	private String generateAutomaticShortname(){
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

	private URL getShortUrlFromShortName(UncheckedShortName shortName) {
	    try{
            return new URL(baseUrl, shortName.toString());
        } catch (MalformedURLException e){
	        return null;
        }
    }

	private ShortUrl addToListIfUniqe(ShortUrl shortUrl) throws URLShortenerException{
        if(shortUrls.stream().anyMatch(s1 -> shortUrl.url().equals(s1.url()))){
            throw new URLShortenerException("stuff", new Throwable());
        }

        shortUrls.add(shortUrl);

        return shortUrl;
    }

}
