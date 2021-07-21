package com.cgs.exception;




public class BeanPropertyValidationException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 125452L;

	public BeanPropertyValidationException(String exception) {
		super(exception);
	}

}
