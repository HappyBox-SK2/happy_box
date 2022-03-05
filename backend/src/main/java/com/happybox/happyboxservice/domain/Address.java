package com.happybox.happyboxservice.domain;

import static lombok.AccessLevel.*;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Address { // 값타입 기본예제
	private String city;
	private String street;
	private String zipcode;

	public Address(String city, String street, String zipcode) {
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
}
