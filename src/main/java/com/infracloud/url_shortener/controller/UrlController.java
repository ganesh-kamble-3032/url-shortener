package com.infracloud.url_shortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infracloud.url_shortener.dto.UrlRequest;
import com.infracloud.url_shortener.dto.UrlResponse;
import com.infracloud.url_shortener.service.UrlService;

/*
 * Controller for shortening URLs
 */
@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public UrlResponse shortenUrl(@RequestBody UrlRequest request) throws Exception {
        String shortUrl = urlService.shortenurl(request.getUrl());
        return new UrlResponse(shortUrl);
    }
}
