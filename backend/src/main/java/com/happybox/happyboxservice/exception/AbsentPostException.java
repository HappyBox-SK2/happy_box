package com.happybox.happyboxservice.exception;

public class AbsentPostException extends RuntimeException {
	public AbsentPostException() {
		super();
	}

	public AbsentPostException(ExceptionMessage message) {
		super(message.toString());
	}

	public AbsentPostException(ExceptionMessage message, Throwable cause) {
		super(message.toString(), cause);
	}

	public AbsentPostException(Throwable cause) {
		super(cause);
	}

}
