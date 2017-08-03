package com.reviewportal.rest.controller.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewportal.model.entities.ReviewWriter;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.impl.services.member.ReviewWriterMemberServicesImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/member/rewview_writer")
@Api(tags = { "Review Writer Operations" })
public class ReviewWriterMemberResource extends AbstractMemberResource<ReviewWriter, ReviewWriterDTO> {

	public static final Logger logger = LoggerFactory.getLogger(ReviewWriterMemberResource.class);

	public ReviewWriterMemberResource() {
		super();
	}

	public ReviewWriterMemberResource(ReviewWriterMemberServicesImpl memberServices) {
		super(memberServices);
	}

}