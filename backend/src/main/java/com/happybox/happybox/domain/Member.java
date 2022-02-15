package com.happybox.happybox.domain;

public class Member {

	private Long id = 1L;
	private final String nickname;
	private final String email;
	private final String password;

	public Long getId() {
		return id;
	}

	public static class Builder {
		private final String nickname;
		private final String email;
		private final String password;

		public Builder(String nickname, String email, String password) {
			this.nickname = nickname;
			this.email = email;
			this.password = password;
		}

		public Member build() {
			return new Member(this);
		}
	}

	private Member(Builder builder) {
		nickname = builder.nickname;
		email = builder.email;
		password = builder.password;
	}

	public String getNickname() {
		return nickname;
	}

	@Override
	public String toString() {
		return "[닉네임: " + nickname + "]";
	}

}
