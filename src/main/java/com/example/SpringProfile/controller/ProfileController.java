package com.example.SpringProfile.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
	
	// Injecting the value of 'my.website.name'
    // property from configuration
    @Value("${my.website.name}")
    private String myWebsiteName;
	
	@RequestMapping("/api")
	public String welcome() {
		return "Welcome "+myWebsiteName;
		
	}
}
