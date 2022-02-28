package com.happybox.happyboxservice.exception;

public class DuplicatedMemberException extends RuntimeException {
	public DuplicatedMemberException() {
		super();
	}

	public DuplicatedMemberException(ExceptionMessage message) {
		super(message.toString());
	}

	public DuplicatedMemberException(ExceptionMessage message, Throwable cause) {
		super(message.toString(), cause);
	}

	public DuplicatedMemberException(Throwable cause) {
		super(cause);
	}

}
