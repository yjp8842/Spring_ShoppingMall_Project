package com.example.shoppingmall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Member {
    private int id;
    private String userId;
    private String name;
    private String password;
    private String email;
    private String contact;

    public Member(String userId, String name, String password, String email, String contact) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.contact = contact;
    }

    public static Member fromDtoToEntity(MemberDto memberDto) {
        return new Member(
                memberDto.getUserId(),
                memberDto.getName(),
                memberDto.getPassword(),
                memberDto.getEmail(),
                memberDto.getContact()
        );
    }

    @Override
    public String toString() {
        return "Member{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
