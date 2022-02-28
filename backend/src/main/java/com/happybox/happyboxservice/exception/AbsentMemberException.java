package com.happybox.happyboxservice.exception;

public class AbsentMemberException extends RuntimeException {
	public AbsentMemberException() {
		super();
	}

	public AbsentMemberException(ExceptionMessage message) {
		super(message.toString());
	}

	public AbsentMemberException(ExceptionMessage message, Throwable cause) {
		super(message.toString(), cause);
	}

	public AbsentMemberException(Throwable cause) {
		super(cause);
	}
}
