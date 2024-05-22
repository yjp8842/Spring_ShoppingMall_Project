package com.example.shoppingmall.member;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class MemberService {
    MemberRepository memberRepository;

    public Member join(Member member) {
        memberRepository.save(member);

        return memberRepository.findByUserId(member.getUserId());
    }

    public boolean checkDuplicateId(String userId) {
        Member existMember
                = memberRepository.findByUserId(userId);

        if (existMember == null)
            return false;
        else
            return true;
    }

    public Member signIn(String userId, String password) {
        return memberRepository.findByUserId(userId);
    }

//    public void getConnection() {
//        memberRepository.getConnection();
//    }
}
