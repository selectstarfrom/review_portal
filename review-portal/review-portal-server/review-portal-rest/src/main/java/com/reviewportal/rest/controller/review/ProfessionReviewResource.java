package com.reviewportal.rest.controller.review;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewportal.model.entities.ProfessionReview;
import com.reviewportal.rest.controller.AbstractResource;
import com.reviewportal.service.dto.ProfessionReviewDTO;
import com.reviewportal.service.impl.services.ProfessionReviewServicesImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/review")
@Api(tags = { "Review Operations [Profession]" })
public class ProfessionReviewResource extends AbstractResource<ProfessionReview, ProfessionReviewDTO> {

	public ProfessionReviewResource() {
		super();
		logger = LoggerFactory.getLogger(ProfessionReviewResource.class);
	}

	@Autowired
	public ProfessionReviewResource(ProfessionReviewServicesImpl pService) {
		super(pService);
	}

}