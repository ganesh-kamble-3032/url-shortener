package com.infracloud.url_shortener.store;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

/* Acts like an in-memory database */
@Component
public class InMemoryStore {
	
//	Short code -> Original URL
	public Map<String ,String> shortToLongMap = new ConcurrentHashMap<>();
	
//	Original URl -> Short Code
	public Map<String , String> longToShortMap = new ConcurrentHashMap<>();
	
//	domain -> Count
	public Map<String , Integer> domainCountMap = new ConcurrentHashMap<>();

}
