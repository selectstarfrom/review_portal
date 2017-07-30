package com.reviewportal.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.services.IUserServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/user")
@Api(tags = { "User Operations" })
public class UserResource {

	public static final Logger logger = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	IUserServices userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Get all user's detail", notes = "Get all user's detail")
	public ResponseEntity<?> listAllUsers() {
		List<UserDTO> lUsers = userService.getAll();
		return new ResponseEntity<List<UserDTO>>(lUsers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get user detail by id", notes = "Get user detail by id")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Expected path variables [id]"),
			@ApiResponse(code = 201, message = "") })
	public ResponseEntity<?> getUser(@PathVariable("id") long id) {
		logger.info("Fetching User with id {}", id);
		UserDTO lUser = userService.getById(id);
		return new ResponseEntity<UserDTO>(lUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserDTO lUser, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", lUser);
		userService.save(lUser);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(lUser.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UserDTO pUserDTO) {
		logger.info("Updating User with id {}", id);

		UserDTO lUpdate = userService.update(pUserDTO);
		return new ResponseEntity<UserDTO>(lUpdate, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting User with id {}", id);

		userService.deleteById(id);
		return new ResponseEntity<UserDTO>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Users-----------------------------

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ResponseEntity<UserDTO> deleteAllUsers() {
		logger.info("Deleting All Users");
		userService.deleteAll();
		return new ResponseEntity<UserDTO>(HttpStatus.NO_CONTENT);
	}

}