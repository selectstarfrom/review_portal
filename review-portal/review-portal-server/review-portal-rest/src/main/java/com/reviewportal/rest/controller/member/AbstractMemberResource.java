package com.reviewportal.rest.controller.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.reviewportal.model.entities.AbstractMember;
import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.impl.services.member.AbstractMemberServicesImpl;

public abstract class AbstractMemberResource<E extends AbstractMember, D extends AbstractMemberDTO> {

	public static final Logger logger = LoggerFactory.getLogger(AbstractMemberResource.class);

	@Autowired
	private AbstractMemberServicesImpl<E, D> memberServices;

	public AbstractMemberResource() {
		super();
	}

	public AbstractMemberResource(AbstractMemberServicesImpl<E, D> memberServices) {
		super();
		this.memberServices = memberServices;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> registerMember(@RequestBody D pMemberDTO, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", pMemberDTO);
		memberServices.save(pMemberDTO);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(pMemberDTO.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ResponseEntity<UserDTO> deleteAllUsers() {
		logger.info("Deleting All Member");
		memberServices.deleteAll();
		return new ResponseEntity<UserDTO>(HttpStatus.NO_CONTENT);
	}

}