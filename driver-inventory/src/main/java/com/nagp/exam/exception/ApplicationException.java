package com.nagp.exam.exception;

import javax.lang.model.type.ErrorType;

public abstract class ApplicationException {
	
	private Throwable cause;
	private ErrorType errorType;
	
	public Throwable getCause() {
		return cause;
	}
	public void setCause(Throwable cause) {
		this.cause = cause;
	}
	public ErrorType getErrorType() {
		return errorType;
	}
	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}
	
	

}
