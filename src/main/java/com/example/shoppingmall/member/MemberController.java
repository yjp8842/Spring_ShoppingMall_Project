package com.example.shoppingmall.member;

import com.example.shoppingmall.member.MemberDto.MemberSignInDto;
import com.example.shoppingmall.member.MemberDto.MemberSignUpDto;
import com.example.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;

@RestController
@AllArgsConstructor
@Slf4j
public class MemberController {
    MemberService memberService;

    @PostMapping("/join")
    public ApiUtils.ApiResult join(@RequestBody @Valid MemberSignUpDto memberSignUpDto) {

        /**
         * 회원가입 REQ : MemberSignInReq
         * RES : MemberSignInRes
         * Login Req : MemberLoginReq
         */

        if(isDuplicateId(memberSignUpDto))
            return error("아이디 중복", HttpStatus.CONFLICT);

        Member requestMember = memberSignUpDto.convertToEntity();

        Member user = memberService.join(requestMember);
        return success(user.getUserId());
    }

    private boolean isDuplicateId(MemberSignUpDto memberSignUpDto) {
        return memberService.checkDuplicateId(memberSignUpDto.getUserId());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiUtils.ApiResult<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException errors) {
        Map<String, String> errorMessages = new HashMap<>();

        for (FieldError error: errors.getFieldErrors()) {
            String errorField = error.getField();
            String errorMessage = error.getDefaultMessage();
            errorMessages.put(errorField, errorMessage);
        }

        return error(errorMessages, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/signin")
    public ApiUtils.ApiResult signIn(@RequestBody MemberSignInDto memberSignInDto) {
        Member resultMember = memberService.signIn(memberSignInDto.getUserId());

        if (resultMember == null)
            return error("아이디가 틀렸습니다.", HttpStatus.BAD_REQUEST);

        if (!resultMember.getPassword().equals(memberSignInDto.getPassword()))
            return error("비밀번호가 틀렸습니다.", HttpStatus.BAD_REQUEST);
        return success(resultMember);
    }
}
