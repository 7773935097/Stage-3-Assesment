package com.cognizant.LearnTodayRESTAPI.dao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEnrollmentIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidEnrollmentIdException(String msg) {
		super(msg);
	}
	
}
