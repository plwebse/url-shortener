package urlShortener;

import java.net.URL;

public class ShortUrl {

	
	private URL shortUrl;
	private URL orginalUrl;
	private ShortUrlStatistics shortUrlStatistics;
	
	public ShortUrl(URL orginalUrl, URL shortUrl) {
		this.orginalUrl = orginalUrl;
		this.shortUrl = shortUrl;
	}
	
	public URL url() {
		return shortUrl;
	}
	
	public URL orginalUrl(){
		return orginalUrl;
	}
	
	public ShortUrlStatistics statistics(){
		return shortUrlStatistics;
	}

}
