package com.infracloud.url_shortener.store;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

/* Acts like an in-memory database */
@Component
public class InMemoryStore {

	public Map<String, String> shortToLongMap = new ConcurrentHashMap<>();

	public Map<String, String> longToShortMap = new ConcurrentHashMap<>();

	public Map<String, Integer> domainCountMap = new ConcurrentHashMap<>();

}
