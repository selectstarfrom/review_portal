package com.reviewportal.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.reviewportal.model.entities.AbstractEntity;
import com.reviewportal.service.dto.AbstractDTO;
import com.reviewportal.service.services.ICommonService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public abstract class AbstractResource<E extends AbstractEntity, D extends AbstractDTO> {

	public static Logger logger = null;

	protected ICommonService<E, D> service;

	public AbstractResource() {
		super();
	}

	public AbstractResource(ICommonService<E, D> pService) {
		super();
		service = pService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Get all object's detail", notes = "Get all object's detail")
	public ResponseEntity<?> listAllObjects() {
		List<D> lList = service.getAll();
		return new ResponseEntity<List<D>>(lList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get object detail by id", notes = "Get object detail by id")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Expected path variables [id]"),
			@ApiResponse(code = 201, message = "") })
	public ResponseEntity<?> getObject(@PathVariable("id") long id) {
		logger.info("Fetching Object with id {}", id);
		D lObject = (D) service.getById(id);
		return new ResponseEntity<D>(lObject, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Create object", notes = "Create object")
	public ResponseEntity<?> createObject(@RequestBody D pObject, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Object : {}", pObject);
		service.save(pObject);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/object/{id}").buildAndExpand(pObject.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update object by Id", notes = "Update object by Id, Expected the entire object with boht modified and unmodified details")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody D pObjectDTO) {
		logger.info("Updating Object with id {}", id);

		D lUpdate = service.update(pObjectDTO);
		return new ResponseEntity<D>(lUpdate, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete object by Id", notes = "Delete object by Id")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Object with id {}", id);

		service.deleteById(id);
		return new ResponseEntity<D>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete all objects", notes = "Delete all objects")
	public ResponseEntity<D> deleteAll() {
		logger.info("Deleting All Objects");
		service.deleteAll();
		return new ResponseEntity<D>(HttpStatus.NO_CONTENT);
	}

}