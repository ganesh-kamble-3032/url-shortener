package com.infracloud.url_shortener;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.infracloud.url_shortener.service.UrlService;

@SpringBootTest
class UrlShortenerApplicationTests {
	
	@Autowired
    private UrlService urlService;
	
	 @Test
	    void sameUrlShouldReturnSameShortUrl() throws Exception {
	        String url = "https://www.youtube.com/watch?v=abc";

	        String first = urlService.shortenurl(url);
	        String second = urlService.shortenurl(url);

	        assertEquals(first, second);
	    }



	@Test
	void contextLoads() {
	}

}
