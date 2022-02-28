package com.happybox.happyboxservice.service;

import java.util.List;

import com.happybox.happyboxservice.domain.Post;

public interface PostService {

	void savePost(Post post);

	List<Post> findPosts();

	Post findOne(Long id);
}
