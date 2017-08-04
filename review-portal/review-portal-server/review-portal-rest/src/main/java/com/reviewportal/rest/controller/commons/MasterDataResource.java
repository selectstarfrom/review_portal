package com.reviewportal.rest.controller.commons;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reviewportal.rest.controller.AbstractBaseResource;
import com.reviewportal.service.impl.services.MasterDataServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/master-data")
@Api(tags = { "Master Data Operations" })
public class MasterDataResource extends AbstractBaseResource {

	@Autowired
	private MasterDataServices masterDataServices;

	public MasterDataResource() {
		super();
		logger = LoggerFactory.getLogger(MasterDataResource.class);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Get all Profession Titles", notes = "Get all Profession Titles")
	public ResponseEntity<List<String>> getAllProfessions() {
		List<String> lList = masterDataServices.getAllProfessions();
		return new ResponseEntity<List<String>>(lList, HttpStatus.OK);
	}

}