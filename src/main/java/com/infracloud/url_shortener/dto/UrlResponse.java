package com.infracloud.url_shortener.dto;


/* Response object for returning short URL  */

public class UrlResponse {
	
	private String shortUrl;
	
	public UrlResponse(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	public String getShortUrl() {
		return shortUrl;
	}

}
