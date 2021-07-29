package com.cgs.currency.custom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CurrencyFundFailedException  extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 20l;
	
	public CurrencyFundFailedException(String message) {
		super(message);
	}
	
	

}
