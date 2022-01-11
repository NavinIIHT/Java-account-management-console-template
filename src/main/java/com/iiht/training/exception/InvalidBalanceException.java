package com.iiht.training.exception;

public class InvalidBalanceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidBalanceException() {
		super();
	}

	public InvalidBalanceException(String message) {
		super(message);
	}

}
