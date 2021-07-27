package com.cgs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HsmEntityToDtoConversionException extends RuntimeException{
	
	private static final long serialVersionUID = 125554L;

	public HsmEntityToDtoConversionException(String exception) {
		super(exception);
		 
	}
	
}
