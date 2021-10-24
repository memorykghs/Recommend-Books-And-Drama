package com.team.rbad.exception;

/**
 * ErrorInputException
 * @author memorykghs
 */
public class ErrorInputException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ErrorInputException() {}
	
	public ErrorInputException(String msg) {
		super(msg);
	}

}
