package com.infracloud.url_shortener.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infracloud.url_shortener.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;

// Handles redirection of short URL 

@RestController
public class RedirectController {
	
	@Autowired
    private UrlService urlService;
	
    @GetMapping("/u/{code}")
    public void redirectToOriginal(
            @PathVariable String code,
            HttpServletResponse response) throws IOException {

        String originalUrl = urlService.getOriginalUrl(code);

        if (originalUrl == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        response.sendRedirect(originalUrl);
    }



}
