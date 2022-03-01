package com.happybox.happyboxservice.domain;

import static javax.persistence.FetchType.*;

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

import lombok.Getter;

@Entity
@Getter
public class Post {

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private final List<Comment> comments = new ArrayList<>();

	@Id
	@GeneratedValue
	@Column(name = "post_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	private String title;

	protected Post() {
	}

	public Post(Member member, String title) {
		this.member = member;
		this.title = title;
		member.getPosts().add(this);
	}
}
