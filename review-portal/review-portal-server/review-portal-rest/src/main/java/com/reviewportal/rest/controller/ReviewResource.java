package com.reviewportal.rest.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewportal.model.entities.ProfessionReview;
import com.reviewportal.service.dto.ProfessionReviewDTO;
import com.reviewportal.service.impl.services.ProfessionReviewServicesImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/review")
@Api(tags = { "Review Operations" })
public class ReviewResource extends AbstractResource<ProfessionReview, ProfessionReviewDTO> {

	public ReviewResource() {
		super();
		logger = LoggerFactory.getLogger(ReviewResource.class);
	}

	@Autowired
	public ReviewResource(ProfessionReviewServicesImpl pService) {
		super(pService);
	}

}