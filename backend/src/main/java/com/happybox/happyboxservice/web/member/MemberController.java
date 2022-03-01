package com.happybox.happyboxservice.web.member;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.happybox.happyboxservice.domain.Member;
import com.happybox.happyboxservice.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/members/new")
	public String createForm(Model model) {
		model.addAttribute("memberForm", new MemberForm());
		return "members/createMemberForm";
	}

	@PostMapping("/members/new")
	public String create(@Valid MemberForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "members/createMemberForm";
		}

		Member member = new Member.Builder().name(form.getName()).build();
		memberService.join(member);
		return "redirect:/";
	}


	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		// TODO 화면 DTO로 변환하여 출력하는 것이 좋다. 엔티티는 외부에 절대로 그냥 반환하면 안된다.
		return "members/memberList";
	}
}
