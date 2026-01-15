package com.infracloud.url_shortener.service;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infracloud.url_shortener.store.InMemoryStore;
import com.infracloud.url_shortener.util.ShortCodeGenerator;

/* Business Logic for URL Shortening */

@Service
public class UrlService {

	private static final String BASE_URL = "\"http://localhost:8080/u/\"";

	@Autowired
	private InMemoryStore store;

	/*
	 * Shortens a URl If URL Already exists, return existing short URL
	 */

	public String shortenurl(String originalUrl) throws Exception {

		// Already exits -> return same short URL
		if (store.longToShortMap.containsKey(originalUrl)) {
			return BASE_URL + store.longToShortMap.get(originalUrl);
		}

		// Generate new short code
		String shortcode = ShortCodeGenerator.generateShortCode();

//        Saving mappings
		store.longToShortMap.put(originalUrl, shortcode);
		store.shortToLongMap.put(shortcode, originalUrl);

		// Extract domain for metrics
		URI uri = new URI(originalUrl);
		String domain = uri.getHost();

		store.domainCountMap.merge(domain, 1, Integer::sum);
		return BASE_URL + shortcode;
	}

//		Fetch original URL for redirect
	public String getOriginalUrl(String shortcode) {
		return store.shortToLongMap.get(shortcode);

	}

//		Returns top 3 most shortened domains
	public Map<String,Integer> getTopDomains()
	{
		return store.domainCountMap.entrySet()
				.stream()
				.sorted((a, b) -> b.getValue() - a.getValue())
				.limit(3)
				.collect(Collectors.toMap(
						Map.Entry::getKey, 
						Map.Entry::getValue,
						(a, b) -> a,
						LinkedHashMap::new));

	}

}
