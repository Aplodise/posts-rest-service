package com.roman.restapi.controller;

import com.roman.restapi.dto.PostDto;
import com.roman.restapi.dto.PostMapper;
import com.roman.restapi.model.Post;
import com.roman.restapi.service.PostService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class PostController {

    private final PostService postService;
    @GetMapping("/posts")
    public List<PostDto> getPosts(@RequestParam(required = false, defaultValue = "0") Integer page, Sort.Direction sort,
                                  @AuthenticationPrincipal UsernamePasswordAuthenticationToken user){
        return PostMapper.mapToPostDtos(postService.getPosts(page, sort));
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostsWithComments(@RequestParam(required = false, defaultValue = "0") int page, Sort.Direction sort){
        return postService.getPostsWithComments(page, sort);
    }
    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable long id){
        return postService.getPost(id);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post){
        return postService.addPost(post);
    }

    @PutMapping("/posts")
    public Post editPost(@RequestBody Post post){
        return postService.editPost(post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable long id){
        postService.deletePost(id);
    }
}
