package com.example.shoppingmall.member;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {
    Map<String, Member> memberTable = new HashMap<>();

    public String save(Member member) {
        memberTable.put(member.getUserId(), member);

        Member savedMember = memberTable.get(member.getUserId());
        return savedMember.getUserId();
    }

    public String signIn(Map<String, String> userInfo) {
        String result = "";

        for (Member member : memberTable.values()) {
            if (member.getUserId().equals(userInfo.get("userId")) &&
                    member.getPassword().equals(userInfo.get("password"))) {
                result = member.getUserId();
            }
        }

        return result;
    }
}
