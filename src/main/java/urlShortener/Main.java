package urlShortener;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.function.Function;

import urlShortener.exceptions.URLShortenerException;

public class Main {

	public static void main(String[] args) throws MalformedURLException, URLShortenerException {
		System.out.println("hello");
		
		Arrays.stream((new File("/tmp/")).listFiles())
        .map(Unchecked.function(File::getCanonicalPath))
        .forEach(System.out::println);
		
		
		
		URLShortenerService urlShortenerService = new URLShortenerServiceImpl(new URL("http://plweb.se"));
		urlShortenerService.convertToShortUrl(new URL("http://binaryti.me/all-about-binary-time"), new UncheckedShortName("binarytime"));
	
		
		System.out.println(urlShortenerService.convertToShortUrl(new URL("http://binaryti.me/all-about-binary-time")).url().toString());
	}
	
	@FunctionalInterface
	public interface CheckedFunction<T, R> {
	    R apply(T t) throws Throwable;
	}
	
	static class Unchecked {
		  public static <T, R> Function<T, R> function(CheckedFunction<T, R> function) {
		    return t -> {
		        try {
		            return function.apply(t);
		        }
		        catch (Throwable e) {
		          if (e instanceof Error) {
		              throw (Error) e;
		          }
		          if (e instanceof RuntimeException) {
		              throw (RuntimeException) e;
		          }
		          throw new RuntimeException(e);
		        }
		    };
		  }
		}

}
