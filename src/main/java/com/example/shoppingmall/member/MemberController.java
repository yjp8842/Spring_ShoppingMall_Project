package com.example.shoppingmall.member;

import com.example.shoppingmall.utils.ApiUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;

@RestController
@AllArgsConstructor
@Slf4j
public class MemberController<T> {
    MemberService memberService;

    @PostMapping("/join/api/result")
    public ApiUtils.ApiResult joinByApiResult(@RequestBody Member member) {
        log.info(member.toString());

        if(isDuplicateId(member))
            return error("아이디 중복", HttpStatus.CONFLICT);

        String userId = memberService.join(member);
        return success(userId);
    }

    private boolean isDuplicateId(Member member) {
        return memberService.checkDuplicateId(member.getUserId());
    }

//    @PostMapping("/signin")
//    public ResponseEntity<Map<String, String>> signIn(@RequestBody Map<String, String> userInfo) {
//        String result = memberService.signIn(userInfo);
//
//
//    }
}
