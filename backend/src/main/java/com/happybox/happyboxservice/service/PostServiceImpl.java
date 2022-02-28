package com.happybox.happyboxservice.service;

import static com.happybox.happyboxservice.exception.ExceptionMessage.*;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happybox.happyboxservice.domain.Post;
import com.happybox.happyboxservice.exception.AbsentPostException;
import com.happybox.happyboxservice.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;

	@Transactional
	@Override
	public void savePost(Post post) {
		postRepository.save(post);
	}

	@Override
	public List<Post> findPosts() {
		return postRepository.findAll();
	}

	@Override
	public Post findOne(Long id) {
		return postRepository.findById(id)
			.orElseThrow(() -> new AbsentPostException(ABSENT_POST_MASSAGE));
	}
}
