package com.happybox.happyboxservice.exception;

public class PasswordDoesNotMatchException extends RuntimeException{
	public PasswordDoesNotMatchException() {
		super();
	}

	public PasswordDoesNotMatchException(ExceptionMessage message) {
		super(message.toString());
	}

	public PasswordDoesNotMatchException(ExceptionMessage message, Throwable cause) {
		super(message.toString(), cause);
	}

	public PasswordDoesNotMatchException(Throwable cause) {
		super(cause);
	}
}
