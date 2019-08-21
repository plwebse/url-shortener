package urlShortener;

import urlShortener.exceptions.URLShortenerNamingException;


import java.util.stream.Stream;

public class UncheckedShortName {
	private String shortName;
	private Stream<String> abusiveWords = Stream.of("xxx", "whore", "pc");
	private final static String A_Z_0_9 = "[a-zA-Z0-9]*";

	public UncheckedShortName(String shortName) throws URLShortenerNamingException {
		this.shortName = shortName;
		validate();			
	}

	private void validate() throws URLShortenerNamingException{
		if(shortName == null){
			throwUSNException("Not a valid shortname a");
		}

		if(!shortName.matches(A_Z_0_9)){
			throwUSNException("Not a valid shortname b");
		}

        if(abusiveWords.anyMatch(abusiveWord -> shortName.contains(abusiveWord))){
			throwUSNException("Not a valid shortname c");
        }
	}

	private void throwUSNException(String message) throws URLShortenerNamingException {
		throw new URLShortenerNamingException(message, new Throwable());
	}

	@Override
	public String toString() {
		return shortName;
	}

}
