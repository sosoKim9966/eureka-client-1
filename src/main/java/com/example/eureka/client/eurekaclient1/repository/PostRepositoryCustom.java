package com.example.eureka.client.eurekaclient1.repository;

import com.example.eureka.client.eurekaclient1.domain.Post;
import com.example.eureka.client.eurekaclient1.dto.PostUserDto;

import java.util.List;

public interface PostRepositoryCustom {
    List<Post> getPost();
    List<Post> getPostsFetchJoin();
    List<Post> getPostsNoRelation();
    List<PostUserDto> getDto();
}
