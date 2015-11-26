package com.mahdidoc.exception;

import org.springframework.http.HttpStatus;

public class DocException extends Exception {
	
	public DocException() {
		super();
	}
	
	public DocException(HttpStatus expectationFailed, Exception ex) {
		super(expectationFailed.name(), ex);
	}

}
