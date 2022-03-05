package com.happybox.happyboxservice.domain;

import static javax.persistence.FetchType.*;
import static lombok.AccessLevel.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Post {

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<Comment> comments = new ArrayList<>();

	@Id
	@GeneratedValue
	@Column(name = "post_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@NotEmpty
	private String title;

	private Boolean like;

	public Post(Member member, String title) {
		this.member = member;
		this.title = title;
		member.getPosts().add(this);
	}

	public boolean toggleLike() {
		return getLike() != getLike();
	}
	// TODO 테스트 필요
}
