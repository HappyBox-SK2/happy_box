package com.happybox.happyboxservice.service;

import java.util.List;

import com.happybox.happyboxservice.domain.Member;

public interface MemberService {

	/**
	 * 회원 가입
	 */
	Long join(Member member);

	/**
	 * 회원 조회
	 */
	List<Member> findMembers();

	Member findOne(Long id);

	Member findOne(String name);

	void changeName(String name, UpdateMemberDto memberDto);
}
