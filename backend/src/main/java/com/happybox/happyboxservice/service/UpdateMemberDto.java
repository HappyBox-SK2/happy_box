package com.happybox.happyboxservice.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateMemberDto {

	private String updateData;
	private String password;
}
