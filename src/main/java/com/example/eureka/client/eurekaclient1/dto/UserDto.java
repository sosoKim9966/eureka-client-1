package com.example.eureka.client.eurekaclient1.dto;

import com.example.eureka.client.eurekaclient1.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {

    private String email;
    private String userName;
    private String password;

    public User toEntity(){
        return User.builder()
                .email(email)
                .userName(userName)
                .password(password)
                .build();
    }
}
