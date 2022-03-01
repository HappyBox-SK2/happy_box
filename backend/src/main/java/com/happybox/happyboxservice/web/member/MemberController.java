package com.happybox.happyboxservice.web.member;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.happybox.happyboxservice.domain.Member;
import com.happybox.happyboxservice.service.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberServiceImpl memberService;

	@GetMapping("/members/new")
	public String createForm(Model model) {
		model.addAttribute("memberForm", new MemberForm());
		return "members/createMemberForm";
	}

	@PostMapping("/members/new")
	public String create(MemberForm form) {
		return "redirect:/";
	}

	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "members/memberList";
	}
}
