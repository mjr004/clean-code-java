package com.clean.code.exceptions;

public class CannotWalkException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CannotWalkException(String message) {
        super(message);
    }
}
