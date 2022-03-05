package com.happybox.happyboxservice.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.happybox.happyboxservice.domain.Member;
import com.happybox.happyboxservice.exception.DuplicatedMemberException;
import com.happybox.happyboxservice.exception.PasswordDoesNotMatchException;
import com.happybox.happyboxservice.repository.MemberRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;

	@Test
	@DisplayName("회원가입")
	public void join() throws Exception {
		//given
		Member member = new Member.Builder().name("Lim").password("password").build();

		//when
		Long savedId = memberService.join(member);

		//then
		assertEquals(member, memberRepository.findById(savedId).orElseThrow(IllegalArgumentException::new));
	}

	@Test
	@DisplayName("중복된 이름으로 회원가입")
	public void joinDuplicated() throws Exception {
		//given
		Member member1 = new Member.Builder().name("Lim").password("password").build();
		Member member2 = new Member.Builder().name("Lim").password("password").build();

		//when
		memberService.join(member1);

		//then
		assertThrows(DuplicatedMemberException.class,
			() -> memberService.join(member2));

	}

	@Test
	@DisplayName("이름 변경, 비밀번호가 올바른 경우")
	public void changeNameValid() throws Exception {
		//given
		Member member = new Member.Builder().name("Test").password("password").build();
		memberService.join(member);

		String updateName = "Kim";
		UpdateMemberDto memberDto = new UpdateMemberDto(updateName, member.getPassword());

		//when
		memberService.changeName(member.getName(), memberDto);

		//then
		assertThat(member.getName()).isEqualTo(updateName);
	}

	@Test
	@DisplayName("이름 변경, 비밀번호가 올바르지 않은 경우")
	public void changeNameWrong() throws Exception {
		//given
		Member member = new Member.Builder().name("Test").password("password").build();
		memberService.join(member);

		UpdateMemberDto memberDto = new UpdateMemberDto("FAIL", "WRONG");
		//then
		assertThrows(PasswordDoesNotMatchException.class,
			() -> memberService.changeName(member.getName(), memberDto));
	}
}