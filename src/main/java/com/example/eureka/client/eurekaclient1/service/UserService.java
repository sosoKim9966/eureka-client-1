package com.example.eureka.client.eurekaclient1.service;

import com.example.eureka.client.eurekaclient1.domain.User;
import com.example.eureka.client.eurekaclient1.dto.UserDto;
import com.example.eureka.client.eurekaclient1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(m -> UserDto.builder()
                        .userName(m.getUserName())
                        .email(m.getEmail())
                        .password(m.getPassword())
                        .build())
                .collect(Collectors.toList());
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean save(UserDto userDto) {
        if(!userRepository.existsByEmail(userDto.getEmail())) {
            User user = userDto.toEntity();
            userRepository.save(user);
            return true;
        }

        return false;
    }
}


