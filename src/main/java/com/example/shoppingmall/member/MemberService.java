package com.example.shoppingmall.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class MemberService {
    MemberRepository memberRepository;

    public String join(Member member) {
        return memberRepository.save(member);
    }

    public boolean checkDuplicateId(String userId) {
        Member existMember
                = memberRepository.findById(userId);

        if (existMember == null)
            return false;
        else
            return true;
    }

    public String signIn(Map<String, String> userInfo) {
        return memberRepository.signIn(userInfo);
    }
}
