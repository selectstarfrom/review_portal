package com.reviewportal.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.reviewportal" })
public class ReviewPortalApp {

	public static void main(String[] args) {
		SpringApplication.run(ReviewPortalApp.class, args);
	}
}