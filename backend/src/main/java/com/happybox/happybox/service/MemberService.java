package com.happybox.happybox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happybox.happybox.domain.Member;
import com.happybox.happybox.repository.MemberRepository;
import com.happybox.happybox.repository.MemoryMemberRepository;


@Service
public class MemberService { // 서비스는 단어선정을 보면 비지니스적임
	private final MemberRepository memberRepository;

	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Long join(Member member) {
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findById(member.getId()).ifPresent(m -> {
			throw new IllegalStateException("[ERROR] 이미 존재하는 회원입니다.");
		});
	}

	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long id) {
		return memberRepository.findById(id);
	}
}
