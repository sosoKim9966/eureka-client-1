package com.example.eureka.client.eurekaclient1.repository.impl;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.example.eureka.client.eurekaclient1.domain.Post;
import com.example.eureka.client.eurekaclient1.dto.PostUserDto;

import com.example.eureka.client.eurekaclient1.repository.PostRepositoryCustom;

import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.eureka.client.eurekaclient1.domain.QPost.post;
import static com.example.eureka.client.eurekaclient1.domain.QUser.user;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Post> getPosts() {
        return jpaQueryFactory
                .selectFrom(post)
                .join(post.user, user)
                .fetch();
    }

    @Override
    public List<Post> getPostsFetchJoin() {
        return jpaQueryFactory
                .selectFrom(post)
                .join(post.user, user)
                .fetchJoin()
                .fetch();
    }

    @Override
    public List<Post> getPostsNoRelation() {
        return jpaQueryFactory
                .selectFrom(post)
                .join(user).on(post.user.id.eq(user.id))
                .fetch();
    }

    @Override
    public List<PostUserDto> getDto() {
        return null;
    }

}
