package urlShortener;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ShortUrlStatistics {
	
	private ShortUrl shortUrl;
	private List<ShortUrlStatisticsEntry> shortUrlStatisticsEntries = new ArrayList<ShortUrlStatisticsEntry>();
	private int visits = shortUrlStatisticsEntries.size();
	
	protected ShortUrlStatistics() {}
	
	public ShortUrlStatistics(ShortUrl shortUrl) {
		this.shortUrl = shortUrl;
	}
	
	public List<ShortUrlStatisticsEntry> statisticsEntries() {
		return shortUrlStatisticsEntries;
	}
	
	public List<ShortUrlStatisticsEntry> statisticsEntries(Predicate<ShortUrlStatistics> predicate) {
		return shortUrlStatisticsEntries;
	}
}
