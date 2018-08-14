package urlShortener;

import java.net.URL;

public class ShortUrl {

	private URL shortUrl;
	private URL originalUrl;
	private ShortUrlStatistics shortUrlStatistics;
	
	public ShortUrl(URL originalUrl, URL shortUrl) {
		this.originalUrl = originalUrl;
		this.shortUrl = shortUrl;
	}
	
	public URL url() {
		return shortUrl;
	}
	
	public URL originalUrl(){
		return originalUrl;
	}
	
	public ShortUrlStatistics statistics(){
		return shortUrlStatistics;
	}

    @Override
    public String toString() {
        return "ShortUrl{" + "shortUrl=" + shortUrl + ", originalUrl=" + originalUrl + ", shortUrlStatistics=" + shortUrlStatistics + '}';
    }
}
