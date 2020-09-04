package com.nagp.exam.models;

import org.springframework.http.HttpStatus;

public enum ErrorType {
	
	FAILED("Failed operation","failed.operation",HttpStatus.INTERNAL_SERVER_ERROR);
	
	private String message;
	private String errorCode;
	private HttpStatus status;
	
	private ErrorType(String message, String errorCode, HttpStatus status) {
		this.message = message;
		this.errorCode = errorCode;
		this.status = status;
	}
	
	

}
