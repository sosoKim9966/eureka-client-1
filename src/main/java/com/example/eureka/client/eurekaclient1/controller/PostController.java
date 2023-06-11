package com.example.eureka.client.eurekaclient1.controller;

import com.example.eureka.client.eurekaclient1.dto.PostDto;
import com.example.eureka.client.eurekaclient1.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Join;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts")
@RequiredArgsConstructor
@Api(tags = {"게시물 API"})
public class PostController {

    final private PostService postService;

    @GetMapping(value = "/search")
    @ApiOperation(value = "조회", response = Join.class)
    public ResponseEntity<?> searchPost(@RequestBody PostDto postDto){

        return new ResponseEntity<>(postService.findByTitleOrContent(postDto.getTitle(),postDto.getContent()), HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<?> getAllPost(){

        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/detail")
    public ResponseEntity<?> getDetailPost(@RequestBody PostDto postDto){

        return new ResponseEntity<>(postService.findPostById(postDto.getId()), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> savePost(@RequestBody PostDto postDto){

        return new ResponseEntity<>(postService.save(postDto), HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<?> updatePost(@RequestBody PostDto postDto){

        return new ResponseEntity<>(postService.updatePost(postDto), HttpStatus.OK);
    }



}
