package com.roman.restapi.service;

import com.roman.restapi.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
@WithMockUser
class PostServiceTest {

    @Autowired
    private PostService postService;
    @Test
    void shouldGetSinglePost() {

        //when
        Post singlePost =  postService.getPost(1L);
        assertThat(singlePost).isNotNull();
        assertThat(singlePost.getId()).isEqualTo(1L);
    }
}