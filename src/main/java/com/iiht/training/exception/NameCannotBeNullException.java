package com.iiht.training.exception;

public class NameCannotBeNullException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NameCannotBeNullException() {
		super();
	}

	public NameCannotBeNullException(String message) {
		super(message);
	}

}
