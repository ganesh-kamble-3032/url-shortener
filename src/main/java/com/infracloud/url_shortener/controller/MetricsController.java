package com.infracloud.url_shortener.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infracloud.url_shortener.service.UrlService;

//Controller for metrics API

@RestController
@RequestMapping("/api/metrics")
public class MetricsController {
	
	 @Autowired
	    private UrlService urlService;

	    @GetMapping("/top-domains")
	    public Map<String, Integer> getTopDomains() {
	        return urlService.getTopDomains();
	    }


}
