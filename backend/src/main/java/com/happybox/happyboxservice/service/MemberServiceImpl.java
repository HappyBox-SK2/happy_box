package com.happybox.happyboxservice.service;

import static com.happybox.happyboxservice.exception.ExceptionMessage.*;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happybox.happyboxservice.domain.Member;
import com.happybox.happyboxservice.exception.DuplicatedMemberException;
import com.happybox.happyboxservice.exception.NoSuchMemberException;
import com.happybox.happyboxservice.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	@Transactional
	@Override
	public Long join(Member member) {
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName()).ifPresent(m -> {
			throw new DuplicatedMemberException(DUPLICATED_MEMBER_MASSAGE);
		});
	}

	@Override
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	@Override
	public Member findOne(Long id) {
		return memberRepository.findById(id)
			.orElseThrow(() -> new NoSuchMemberException(NO_SUCH_MEMBER_MASSAGE));
	}

	@Override
	public Member findOne(String name) {
		return memberRepository.findByName(name)
			.orElseThrow(() -> new NoSuchMemberException(NO_SUCH_MEMBER_MASSAGE));
	}

	@Transactional
	@Override
	public void changeName(String name, UpdateMemberDto memberDto) {
		Member member = findOne(name);
		member.updateName(memberDto.getUpdateData(), memberDto.getPassword());
	}
}
