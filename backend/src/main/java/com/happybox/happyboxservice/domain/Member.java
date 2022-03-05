package com.happybox.happyboxservice.domain;

import static com.happybox.happyboxservice.exception.ExceptionMessage.*;
import static lombok.AccessLevel.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.happybox.happyboxservice.exception.PasswordDoesNotMatchException;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member {

	@OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
	private final List<Post> posts = new ArrayList<>();

	@Id
	@GeneratedValue()
	@Column(name = "member_id")
	private Long id;

	@Column(name = "member_name", unique = true)
	@NotEmpty
	private String name;

	@Column(name = "member_password")
	@NotEmpty
	private String password;

	private Member(Builder builder) {
		name = builder.name;
		password = builder.password;
	}

	public void updateName(String name, String password) {
		validatePassword(password);
		this.name = name;
	}

	public void updatePassword(String updatePassword, String originalPassword) {
		validatePassword(originalPassword);
		this.password = updatePassword;
	}

	public void validatePassword(String password) {
		if (!getPassword().equals(password)) {
			throw new PasswordDoesNotMatchException(PASSWORD_DOES_NOT_MATCH_MASSAGE);
		}
	}

	@Override
	public String toString() {
		return "Member{" + "name='" + getName() + '\'' + '}';
	}

	public static class Builder {
		private String name;
		private String password;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Member build() {
			return new Member(this);
		}
	}
}
