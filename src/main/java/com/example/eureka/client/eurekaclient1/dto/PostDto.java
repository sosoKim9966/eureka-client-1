package com.example.eureka.client.eurekaclient1.dto;

import com.example.eureka.client.eurekaclient1.domain.Post;
import com.example.eureka.client.eurekaclient1.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    @Column(name = "post_id")
    private Long id;
    private String title;
    private String content;
    private String email;
    private User user;

    @Builder
    public PostDto(Long id, String title, String content, String email) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.email = email;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .email(email)
                .user(user)
                .build();
    }

}
