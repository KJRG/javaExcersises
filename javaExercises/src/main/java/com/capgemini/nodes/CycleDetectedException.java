package com.capgemini.nodes;

public class CycleDetectedException extends NodeException {
	public CycleDetectedException() {
		super();
	}
	
	public CycleDetectedException(String message) {
		super(message);
	}
	
	public CycleDetectedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CycleDetectedException(Throwable cause) {
		super(cause);
	}
}
