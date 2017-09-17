package urlShortener;

import java.net.URL;

public class ShortUrl {

	
	private URL shortUrl;
	private ShortUrlStatistics shortUrlStatistics;
	
	public ShortUrl(URL shortUrl) {
		this.shortUrl = shortUrl;
	}
	
	public URL url() {
		return shortUrl;
	}
	

}
