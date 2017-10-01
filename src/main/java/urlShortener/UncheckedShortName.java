package urlShortener;

import urlShortener.exceptions.URLShortenerNamingException;

public class UncheckedShortName {
	private String shortName; 
	
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
			
		// TODO check for bad words	
	}
	
	@Override
	public String toString() {
		return shortName;
	}

}
