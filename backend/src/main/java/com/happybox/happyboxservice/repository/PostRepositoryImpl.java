package com.happybox.happyboxservice.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.happybox.happyboxservice.domain.Post;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

	private final EntityManager em;

	@Override
	public void save(Post post) {
		if (isPost(post)) {
			update(post);
			return;
		}
		em.persist(post);
	}

	private boolean isPost(Post post) {
		return post.getId() != null;
	}

	private void update(Post post) {
		em.merge(post);
	}

	@Override
	public Optional<Post> findById(Long id) {
		return Optional.ofNullable(em.find(Post.class, id));
	}

	@Override
	public Optional<Post> findByTitle(String title) {
		return em.createQuery("select p from Post p where p.title = :title", Post.class)
			.setParameter("title", title)
			.getResultStream().findAny();
	}

	@Override
	public List<Post> findAll() {
		return em.createQuery("select p from Post p", Post.class)
			.getResultList();
	}

}
