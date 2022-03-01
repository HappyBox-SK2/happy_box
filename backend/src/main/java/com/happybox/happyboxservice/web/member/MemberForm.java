package com.happybox.happyboxservice.web.member;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;

@Getter
public class MemberForm {

	@NotEmpty(message = "회원 이름은 필수 입니다.")
	private final String name;

	private MemberForm(Builder builder) {
		name = builder.name;
	}

	public static class Builder {
		private String name;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public MemberForm build() {
			return new MemberForm(this);
		}
	}
}