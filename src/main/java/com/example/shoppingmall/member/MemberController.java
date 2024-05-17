package com.example.shoppingmall.member;

import com.example.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;

@RestController
@AllArgsConstructor
@Slf4j
public class MemberController {
    MemberService memberService;

    @PostMapping("/join/api/result")
    public ApiUtils.ApiResult joinByApiResult(@RequestBody @Valid MemberDTO memberDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return error(String.join(", ", errorMessages), HttpStatus.BAD_REQUEST);
        }

        if(isDuplicateId(memberDTO))
            return error("아이디 중복", HttpStatus.CONFLICT);

        Member requestMember = memberDTO.convertToEntity();

        String userId = memberService.join(requestMember);
        return success(userId);
    }

    private boolean isDuplicateId(MemberDTO memberDTO) {
        return memberService.checkDuplicateId(memberDTO.getUserId());
    }

//    @PostMapping("/signin")
//    public ResponseEntity<Map<String, String>> signIn(@RequestBody Map<String, String> userInfo) {
//        String result = memberService.signIn(userInfo);
//
//
//    }
}
