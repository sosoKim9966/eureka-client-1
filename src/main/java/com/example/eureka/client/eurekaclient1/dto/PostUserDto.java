package com.example.eureka.client.eurekaclient1.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostUserDto {

    private String title;
    private String content;
    private String email;
    private String userName;

    @QueryProjection
    public PostUserDto(String title, String content, String email, String userName) {
        this.title = title;
        this.content = content;
        this.email = email;
        this.userName = getUserName();
    }


}
