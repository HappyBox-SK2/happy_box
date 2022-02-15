package com.happybox.happybox.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.happybox.happybox.domain.Member;

@Repository
public class MemoryMemberRepository implements MemberRepository {

	private static final Map<Long, Member> store = new ConcurrentHashMap<>();
	private static final long sequence = 0L;

	@Override
	public void save(Member member) {
		store.put(member.getId(), member);
	}

	@Override
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public Optional<Member> findByName(String name) {
		return Optional.empty();
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}

	public void clearStore() {
		store.clear();
	}
}
