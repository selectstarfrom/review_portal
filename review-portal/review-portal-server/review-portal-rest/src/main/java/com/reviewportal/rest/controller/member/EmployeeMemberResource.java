package com.reviewportal.rest.controller.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewportal.model.entities.Official;
import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.impl.services.member.EmployeeMemberServicesImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/member/officials")
@Api(tags = { "Review Writer Operations" })
public class EmployeeMemberResource extends AbstractMemberResource<Official, OfficialDTO> {

	public static final Logger logger = LoggerFactory.getLogger(EmployeeMemberResource.class);

	public EmployeeMemberResource() {
		super();
	}

	public EmployeeMemberResource(EmployeeMemberServicesImpl memberServices) {
		super(memberServices);
	}

}