package com.onlineproduct.exception;

public class ResourceNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2116975424530176953L;
	
	
	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(String message, Throwable throwable, boolean enableSuppression, boolean writableStack) {
		super(message, throwable, enableSuppression, writableStack);
	}
	
	public ResourceNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException(Throwable throwable) {
		super(throwable);
	}

}
