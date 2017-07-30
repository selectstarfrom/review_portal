package com.reviewportal.service.exceptions;

public class SystemServiceException extends RuntimeException {

	private static final long serialVersionUID = -6676922020992619442L;

	public SystemServiceException(String pMessage, Exception pException) {
		super(pMessage, pException);
	}

}
