package com.example.eureka.client.eurekaclient1.service;

import com.example.eureka.client.eurekaclient1.dto.PostDto;
import com.example.eureka.client.eurekaclient1.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public List<PostDto> findByTitleOrContent(String title, String content) {
        return postRepository.findByTitleOrContent(title, content).stream()
                .map(m -> PostDto.builder()
                        .title(m.getTitle())
                        .content(m.getContent())
                        .build())
                .collect(Collectors.toList());
    }
}
