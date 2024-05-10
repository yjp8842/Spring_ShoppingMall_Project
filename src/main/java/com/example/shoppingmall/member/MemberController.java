package com.example.shoppingmall.member;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
public class MemberController {
    MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> signUp(@RequestBody Member member) {
//        Map<String, String> resultMember = memberService.signUp(member);
//        return new ResponseEntity<>(resultMember, HttpStatus.CREATED);
        log.info(member.toString());
        return null;
    }

//    @PostMapping("/signin")
//    public ResponseEntity<Map<String, String>> signIn(@RequestBody Map<String, String> userInfo) {
//        String result = memberService.signIn(userInfo);
//
//
//    }
}
