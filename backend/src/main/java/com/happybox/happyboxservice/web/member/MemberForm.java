package com.happybox.happyboxservice.web.member;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {

	@NotEmpty(message = "회원 이름은 필수 입니다.")
	private String name;

}