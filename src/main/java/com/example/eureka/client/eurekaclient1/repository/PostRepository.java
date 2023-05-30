package com.example.eureka.client.eurekaclient1.repository;

import com.example.eureka.client.eurekaclient1.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
    List<Post> findByTitleOrContent(String content, String title);
    Post findPostById(Long Id);
}
