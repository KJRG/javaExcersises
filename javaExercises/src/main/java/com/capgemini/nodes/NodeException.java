package com.capgemini.nodes;

public class NodeException extends Exception {
	public NodeException() {
		super();
	}

	public NodeException(String message) {
		super(message);
	}

	public NodeException(String message, Throwable cause) {
		super(message, cause);
	}

	public NodeException(Throwable cause) {
		super(cause);
	}
}
