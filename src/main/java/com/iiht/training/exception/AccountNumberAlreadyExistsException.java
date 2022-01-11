package com.iiht.training.exception;

public class AccountNumberAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccountNumberAlreadyExistsException() {
		super();
	}

	public AccountNumberAlreadyExistsException(String message) {
		super(message);
	}

}
