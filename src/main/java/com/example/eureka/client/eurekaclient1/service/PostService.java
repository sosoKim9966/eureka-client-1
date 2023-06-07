package com.example.eureka.client.eurekaclient1.service;

import com.example.eureka.client.eurekaclient1.domain.Post;
import com.example.eureka.client.eurekaclient1.domain.User;
import com.example.eureka.client.eurekaclient1.dto.PostDto;
import com.example.eureka.client.eurekaclient1.dto.PostUserDto;
import com.example.eureka.client.eurekaclient1.repository.PostRepository;
import com.example.eureka.client.eurekaclient1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public List<PostDto> findByTitleOrContent(String title, String content) {
        return postRepository.findByTitleOrContent(title, content).stream()
                .map(m -> PostDto.builder()
                        .title(m.getTitle())
                        .content(m.getContent())
                        .build())
                .collect(Collectors.toList());
    }

    public PostDto findPostById(Long id) {
        Post post = postRepository.findPostById(id);
        return PostDto.builder().title(post.getTitle()).content(post.getContent())
                .email(post.getEmail()).build();
    }

    public List<PostDto> findAll() {
        return postRepository.findAll().stream()
                .map(m -> PostDto.builder()
                        .id(m.getId())
                        .title(m.getTitle())
                        .content(m.getContent())
                        .email(m.getEmail())
                        .build())
                .collect(Collectors.toList());
    }

    public boolean save(PostDto postDto) {
        User user = userRepository.findByEmail(postDto.getEmail());
        if(user != null) {
            postDto.setUser(user);
            postRepository.save(postDto.toEntity());
            return true;
        }
        return false;
    }

    public boolean updatePost(PostDto postDto) {
        Post post = postRepository.findPostById(postDto.getId());
        if(post != null) {
            post.updatePost(postDto.getTitle(), postDto.getContent());
        }
        return true;
    }

    public List<Post> getPosts() {
        return postRepository.getPosts();
    }

    public List<Post> getPostsFetchJoin(){
       return postRepository.getPostsFetchJoin();
    }

    public List<Post> getPostsNoRelation() { return postRepository.getPostsNoRelation(); }
    public List<PostUserDto> getDto() { return postRepository.getDto(); }




}


