package com.example.shoppingmall.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class MemberService {
    MemberRepository memberRepository;

    public String signUp(Member member) {
        return memberRepository.save(member);
    }

    public String signIn(Map<String, String> userInfo) {
        return memberRepository.signIn(userInfo);
    }
}
