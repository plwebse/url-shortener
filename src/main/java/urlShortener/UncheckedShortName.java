package urlShortener;

import urlShortener.exceptions.URLShortenerNamingException;

import java.util.Arrays;
import java.util.function.Predicate;

public class UncheckedShortName {
	private String shortName;
	private static String[] abusiveWords = {"xxx", "whore"};

	public UncheckedShortName(String shortName) throws URLShortenerNamingException {
		this.shortName = shortName;
		validate();			
	}

	private void validate() throws URLShortenerNamingException{
		if(shortName == null){
			throw new URLShortenerNamingException("Not a valid shortname a", new Throwable());
		}

		if(!shortName.matches("[a-zA-Z0-9]*")){
			throw new URLShortenerNamingException("Not a valid shortname b", new Throwable());
		}

        if(Arrays.stream(abusiveWords).anyMatch(abusiveWord -> shortName.contains(abusiveWord))){
            throw new URLShortenerNamingException("Not a valid shortname c", new Throwable());
        }
			
		// TODO check for bad words	
	}
	
	@Override
	public String toString() {
		return shortName;
	}

}
