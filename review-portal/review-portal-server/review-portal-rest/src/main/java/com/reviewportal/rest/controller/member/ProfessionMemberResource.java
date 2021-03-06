package com.reviewportal.rest.controller.member;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewportal.model.entities.Professional;
import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.impl.services.member.ProfessionalMemberServicesImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/member/professionals")
@Api(tags = { "Member Operations [Profession]" })
public class ProfessionMemberResource extends AbstractMemberResource<Professional, ProfessionalDTO> {

	public ProfessionMemberResource() {
		super();
		logger = LoggerFactory.getLogger(ProfessionMemberResource.class);
	}

	@Autowired
	public ProfessionMemberResource(ProfessionalMemberServicesImpl memberServices) {
		super(memberServices);
		logger = LoggerFactory.getLogger(ProfessionMemberResource.class);
	}

}