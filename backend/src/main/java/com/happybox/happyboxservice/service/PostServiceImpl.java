package com.happybox.happyboxservice.service;

import static com.happybox.happyboxservice.exception.ExceptionMessage.*;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happybox.happyboxservice.domain.Post;
import com.happybox.happyboxservice.exception.NoSuchPostException;
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

	@Transactional
	@Override
	public void updatePost(Long postId, PostDto postDto) {
		Post post = postRepository.findById(postId)
			.orElseThrow(() -> new NoSuchPostException(NO_SUCH_POST_MASSAGE));
		// TODO SET 을 어케할까
	}

	@Override
	public List<Post> findPosts() {
		return postRepository.findAll();
	}

	@Override
	public Post findOne(Long id) {
		return postRepository.findById(id)
			.orElseThrow(() -> new NoSuchPostException(NO_SUCH_POST_MASSAGE));
	}
}
