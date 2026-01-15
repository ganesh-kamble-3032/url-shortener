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

	public String shortenurl(String originalUrl) throws Exception {

		if (store.longToShortMap.containsKey(originalUrl)) {
			return BASE_URL + store.longToShortMap.get(originalUrl);
		}

		String shortcode = ShortCodeGenerator.generateShortCode();

		store.longToShortMap.put(originalUrl, shortcode);
		store.shortToLongMap.put(shortcode, originalUrl);

		URI uri = new URI(originalUrl);
		String domain = uri.getHost();

		store.domainCountMap.merge(domain, 1, Integer::sum);
		return BASE_URL + shortcode;
	}

	public String getOriginalUrl(String shortcode) {
		return store.shortToLongMap.get(shortcode);

	}

	public Map<String, Integer> getTopDomains() {
		return store.domainCountMap.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).limit(3)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

	}

}
