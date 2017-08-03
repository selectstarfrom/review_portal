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

import com.reviewportal.service.dto.ProfessionReviewDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.services.IProfessionReviewServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/review")
@Api(tags = { "Review Operations" })
public class ReviewResource {

	public static final Logger logger = LoggerFactory.getLogger(ReviewResource.class);

	@Autowired
	IProfessionReviewServices reviewServices;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Get all Reviews", notes = "Get all reviews")
	public ResponseEntity<?> listAllReviews() {
		List<ProfessionReviewDTO> lResult = reviewServices.getAll();
		return new ResponseEntity<List<ProfessionReviewDTO>>(lResult, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get review detail by id", notes = "Get review detail by id")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Expected path variables [id]"),
			@ApiResponse(code = 201, message = "") })
	public ResponseEntity<?> getReviewDetail(@PathVariable("id") long id) {
		logger.info("Fetching review with id {}", id);
		ProfessionReviewDTO lResult = reviewServices.getById(id);
		return new ResponseEntity<ProfessionReviewDTO>(lResult, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> createReview(@RequestBody ProfessionReviewDTO pReview, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Professional Review : {}", pReview);
		reviewServices.save(pReview);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/review/{id}").buildAndExpand(pReview.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateReview(@PathVariable("id") long id, @RequestBody ProfessionReviewDTO pUpdateObject) {
		logger.info("Updating Profession Review with id {}", id);

		ProfessionReviewDTO lUpdate = reviewServices.update(pUpdateObject);
		return new ResponseEntity<ProfessionReviewDTO>(lUpdate, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteReview(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Review with id {}", id);

		reviewServices.deleteById(id);
		return new ResponseEntity<ProfessionReviewDTO>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ResponseEntity<UserDTO> deleteAllReviews() {
		logger.info("Deleting All Reviews");
		reviewServices.deleteAll();
		return new ResponseEntity<UserDTO>(HttpStatus.NO_CONTENT);
	}

}