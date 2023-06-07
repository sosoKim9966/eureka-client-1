package com.example.eureka.client.eurekaclient1.repository;

import com.example.eureka.client.eurekaclient1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findUserById(Long id);
    boolean existsByEmail(String email);
}
