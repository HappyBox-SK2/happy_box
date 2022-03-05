package com.happybox.happyboxservice.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.happybox.happyboxservice.domain.Member;
import com.happybox.happyboxservice.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

	private final MemberService memberService;

	@GetMapping("/api/members")
	public ResponseResult members() {
		List<MemberDto> collect = memberService.findMembers().stream()
			.map(member -> new MemberDto(member.getName()))
			.collect(Collectors.toList());
		return new ResponseResult(collect);
	}

	@PostMapping("/api/members")
	public CreateMemberResponse saveMember(@RequestBody @Valid CreateMemberRequest request) {
		Member member = new Member.Builder().name(request.getName()).build();
		Long id = memberService.join(member);
		return new CreateMemberResponse(id);
	}

	@PutMapping("/api/members/{name}")
	public UpdateMemberResponse updateMember(
		@PathVariable("name") String name,
		@RequestBody @Valid UpdateMemberRequest request) {

		memberService.changeName(request.getName(), request.getPassword());
		Member findMember = memberService.findOne(name);
		return new UpdateMemberResponse(findMember.getId(), findMember.getName());
	}

	@Data
	@AllArgsConstructor
	static class ResponseResult<T> {
		private T data;
	}

	@Data
	@AllArgsConstructor
	static class MemberDto {
		private String name;
	}

	@Data
	static class CreateMemberRequest {
		@NotEmpty
		private String name;
	}

	@Data
	static class CreateMemberResponse {
		private Long id;

		public CreateMemberResponse(Long id) {
			this.id = id;
		}
	}

	@Data
	static class UpdateMemberRequest {
		@NotEmpty
		private String name;
		@NotEmpty
		private String password;
	}

	@Data
	@AllArgsConstructor
	static class UpdateMemberResponse {
		private Long id;
		private String name;
	}

}
