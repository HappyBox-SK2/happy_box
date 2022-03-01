package com.happybox.happyboxservice.exception;

public class NoSuchMemberException extends RuntimeException {
	public NoSuchMemberException() {
		super();
	}

	public NoSuchMemberException(ExceptionMessage message) {
		super(message.toString());
	}

	public NoSuchMemberException(ExceptionMessage message, Throwable cause) {
		super(message.toString(), cause);
	}

	public NoSuchMemberException(Throwable cause) {
		super(cause);
	}
}
