package com.capgemini.nodes;

public class InvalidNodeDescriptionException extends NodeException {
	public InvalidNodeDescriptionException() {
		super();
	}

	public InvalidNodeDescriptionException(String message) {
		super(message);
	}

	public InvalidNodeDescriptionException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidNodeDescriptionException(Throwable cause) {
		super(cause);
	}
}
