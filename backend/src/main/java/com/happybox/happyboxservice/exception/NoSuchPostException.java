package com.happybox.happyboxservice.exception;

public class NoSuchPostException extends RuntimeException {
	public NoSuchPostException() {
		super();
	}

	public NoSuchPostException(ExceptionMessage message) {
		super(message.toString());
	}

	public NoSuchPostException(ExceptionMessage message, Throwable cause) {
		super(message.toString(), cause);
	}

	public NoSuchPostException(Throwable cause) {
		super(cause);
	}
}
