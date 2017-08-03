package com.reviewportal.rest.controller.member;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewportal.model.entities.ReviewWriter;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.impl.services.member.ReviewWriterMemberServicesImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/member/review_writer")
@Api(tags = { "Member Operations [Review Writer]" })
public class ReviewWriterMemberResource extends AbstractMemberResource<ReviewWriter, ReviewWriterDTO> {

	public ReviewWriterMemberResource() {
		super();
		logger = LoggerFactory.getLogger(ReviewWriterMemberResource.class);
	}

	@Autowired
	public ReviewWriterMemberResource(ReviewWriterMemberServicesImpl pService) {
		super(pService);
	}

}