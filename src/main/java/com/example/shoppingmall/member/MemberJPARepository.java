package com.example.shoppingmall.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJPARepository
        extends JpaRepository<Member, Integer> {
    Optional<Member> findByUserId(String userId);
}
