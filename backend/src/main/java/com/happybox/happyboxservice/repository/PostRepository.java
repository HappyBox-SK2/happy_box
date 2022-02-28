package com.happybox.happyboxservice.repository;

import java.util.List;
import java.util.Optional;

import com.happybox.happyboxservice.domain.Post;


public interface PostRepository {
	void save(Post post);

	Optional<Post> findById(Long id);

	Optional<Post> findByTitle(String name);

	List<Post> findAll();
}
