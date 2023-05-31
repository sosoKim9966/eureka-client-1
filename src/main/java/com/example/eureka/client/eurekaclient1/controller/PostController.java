package com.example.eureka.client.eurekaclient1.controller;

import com.example.eureka.client.eurekaclient1.dto.PostDto;
import com.example.eureka.client.eurekaclient1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
@RequiredArgsConstructor
public class PostController {

    final private PostService postService;

    @GetMapping("/search")
    public ResponseEntity searchPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.findByTitleOrContent(postDto.getTitle(), postDto.getContent(), HttpStatus.OK);
    }

}
