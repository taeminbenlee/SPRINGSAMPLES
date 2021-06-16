package bit.com.a;

import javax.servlet.ServletContext;

import org.springframework.http.MediaType;

public class MediaTypeUtiles {

	public static MediaType getMediaTypeForFileName(ServletContext servletContext, String filename) {
		
		String minType = servletContext.getMimeType(filename);
		
		try {
		MediaType mediaType = MediaType.parseMediaType(minType);
			return mediaType;
		} catch (Exception e) {
			return MediaType.APPLICATION_OCTET_STREAM;
		}
		
		
		
	}
	
	
	
	
	
	
	
}
