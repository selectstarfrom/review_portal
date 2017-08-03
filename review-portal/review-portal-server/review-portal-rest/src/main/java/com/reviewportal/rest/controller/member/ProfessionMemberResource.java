package com.reviewportal.rest.controller.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewportal.model.entities.Official;
import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.impl.services.member.EmployeeMemberServicesImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/member/professionals")
@Api(tags = { "Member Operations [Profession]" })
public class ProfessionMemberResource extends AbstractMemberResource<Official, OfficialDTO> {

	public static final Logger logger = LoggerFactory.getLogger(ProfessionMemberResource.class);

	public ProfessionMemberResource() {
		super();
	}

	@Autowired
	public ProfessionMemberResource(EmployeeMemberServicesImpl memberServices) {
		super(memberServices);
	}

}