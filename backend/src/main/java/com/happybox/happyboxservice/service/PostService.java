package com.happybox.happyboxservice.service;

import java.util.List;

import com.happybox.happyboxservice.domain.Post;

public interface PostService {

	void savePost(Post post);

	void updatePost(Long postId, PostDto param); // TODO POST parameter 를 만들자.

	List<Post> findPosts();

	Post findOne(Long id);
}
