package com.reviewportal.rest.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reviewportal.model.entities.User;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.impl.services.UserServicesImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/user")
@Api(tags = { "User Operations" })
public class UserResource extends AbstractResource<User, UserDTO> {

	public UserResource() {
		super();
		logger = LoggerFactory.getLogger(UserResource.class);
	}

	@Autowired
	public UserResource(UserServicesImpl pService) {
		super(pService);
	}

}