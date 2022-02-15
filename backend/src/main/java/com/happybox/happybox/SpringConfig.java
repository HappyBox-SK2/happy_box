package com.happybox.happybox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.happybox.happybox.repository.MemberRepository;
import com.happybox.happybox.repository.MemoryMemberRepository;
import com.happybox.happybox.service.MemberService;

// @Configuration // 정형화되지 않은 클래스들 클래스빈 등록할 때
// public class SpringConfig {
// 	@Bean
// 	public MemberService memberService() {
// 		return new MemberService(memberRepository()	);
// 	}
//
// 	@Bean // 레포같은건 나중에 바꿀것이므로 이런식으로 처리하는게 좋다.
// 	public MemberRepository memberRepository() {
// 		return new MemoryMemberRepository();
// 	}
// }
