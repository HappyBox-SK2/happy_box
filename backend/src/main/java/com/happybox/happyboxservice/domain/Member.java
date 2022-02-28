package com.happybox.happyboxservice.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity
@Getter
public class Member {

	@OneToMany(mappedBy = "member")
	private final List<Post> posts = new ArrayList<>();

	@Id
	@GeneratedValue()
	@Column(name = "member_id")
	private Long id;

	@Column(unique = true)
	private String name;

	protected Member() {
	}

	private Member(Builder builder) {
		this.name = builder.name;
	}

	public static class Builder {
		private String name;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Member build() {
			return new Member(this);
		}
	}
}
