package com.happybox.happyboxservice.web.post;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.happybox.happyboxservice.service.PostDto;
import com.happybox.happyboxservice.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@GetMapping("/posts/new")
	public String createForm(Model model) {
		model.addAttribute("form", new PostForm());
		return "posts/createPostForm";
	}

	@PostMapping("/posts/new")
	public String create(@Valid PostForm postForm) {
		return "";
		// TODO
	}

	@GetMapping("/posts/{postId}/edit") // TODO ID가 권한이 있는사람인가?
	public String updatePostForm(@PathVariable("postId") Long postId, @ModelAttribute("form") PostForm form) {
		// TODO: FORM으로 DTO 만들기
		postService.updatePost(postId, new PostDto()); // Dto 업데이트 아직안함
		return "posts/updateItemForm";
	}
}
