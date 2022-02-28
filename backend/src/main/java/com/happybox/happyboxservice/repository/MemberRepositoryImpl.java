package com.happybox.happyboxservice.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.happybox.happyboxservice.domain.Member;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

	private final EntityManager em;

	@Override
	public void save(Member member) {
		em.persist(member);
	}

	@Override
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(em.find(Member.class, id));
	}

	@Override
	public Optional<Member> findByName(String name) {
		return em.createQuery("select m from Member m where m.name = :name", Member.class)
			.setParameter("name", name)
			.getResultStream().findAny();
	}

	@Override
	public List<Member> findAll() {
		return em.createQuery("select m from Member as m", Member.class)
			.getResultList();
	}
}
