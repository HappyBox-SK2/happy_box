package com.happybox.happybox.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.happybox.happybox.domain.Member;
import com.happybox.happybox.repository.MemberRepository;
import com.happybox.happybox.repository.MemoryMemberRepository;

class MemberServiceTest {

	MemberService memberService;
	MemoryMemberRepository memberRepository;

	@BeforeEach
	public void setUp(){
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}

	@Test
	void 회원가입() {
		// given
		Member member = new Member.Builder("nick", "ss", "Ss").build();

		// when
		Long saveId = memberService.join(member);

		// then
		Member result = memberService.findOne(saveId).get();
	}

	@Test
	void 중복_회원_예외() {
		Member member = new Member.Builder("nick", "ss", "Ss").build();
		IllegalStateException e = assertThrows(IllegalStateException.class,
			() -> memberService.join(member));
		assertThat(e.getMessage()).isEqualTo("");
	}

	@Test
	void findOne() {

	}
}