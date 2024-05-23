package com.example.shoppingmall.member.MemberDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignInDto {
    @JsonProperty("user_id")
    private String userId;
    private String password;
}
