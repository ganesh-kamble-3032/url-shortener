package com.infracloud.url_shortener.util;

import java.util.UUID;

/* Utility class to generate short codes */

public class ShortCodeGenerator {

	public static String generateShortCode() {

		return UUID.randomUUID()
				.toString()
				.replace("-", "")
				.substring(0, 6);
		
	}

}
