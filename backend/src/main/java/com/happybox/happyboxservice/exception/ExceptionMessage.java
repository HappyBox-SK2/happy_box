package com.happybox.happyboxservice.exception;

public enum ExceptionMessage {
	DUPLICATED_MEMBER_MASSAGE("[ERROR] 이미 존재하는 회원입니다."),
	ABSENT_MEMBER_MASSAGE("[ERROR] 존재하지 않는 회원입니다."),
	ABSENT_POST_MASSAGE("[ERROR] 존재하지 않는 포스트입니다.");

	private final String message;

	ExceptionMessage(final String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
