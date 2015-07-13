package com.capgemini.nodes;

public class InvalidNodeIdException extends NodeException {
	public InvalidNodeIdException() {
		super();
	}
	
	public InvalidNodeIdException(String message) {
		super(message);
	}
	
	public InvalidNodeIdException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidNodeIdException(Throwable cause) {
		super(cause);
	}
}
