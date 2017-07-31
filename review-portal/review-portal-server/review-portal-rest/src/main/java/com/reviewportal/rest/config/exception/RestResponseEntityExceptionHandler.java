package com.reviewportal.rest.config.exception;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.reviewportal.service.exceptions.SystemServiceException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	Logger LOGGER = Logger.getLogger(RestResponseEntityExceptionHandler.class.getName());

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception pException, Object pBody, HttpHeaders pHeaders,
			HttpStatus pStatus, WebRequest pRequest) {
		return super.handleExceptionInternal(pException, pBody, pHeaders, pStatus, pRequest);
	}

	@ExceptionHandler(value = { SystemServiceException.class })
	protected ResponseEntity<Object> handleSystemServiceException(SystemServiceException pSystemServiceException,
			WebRequest pWebRequest) {

		LOGGER.error("Service Error", pSystemServiceException);

		List<String> errors = new ArrayList<String>();

		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
				pSystemServiceException.getLocalizedMessage(), errors);
		return handleExceptionInternal(pSystemServiceException, apiError, new HttpHeaders(), apiError.getStatus(),
				pWebRequest);
	}

}