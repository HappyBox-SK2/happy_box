package com.happybox.user.domain;

public class User {

	private final String nickname;
	private final String email;
	private final String password;

	public static class Builder {
		private final String nickname;
		private final String email;
		private final String password;

		public Builder(String nickname, String email, String password) {
			this.nickname = nickname;
			this.email = email;
			this.password = password;
		}

		public User build() {
			return new User(this);
		}
	}

	private User(Builder builder) {
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
