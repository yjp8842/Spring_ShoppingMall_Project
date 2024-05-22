package com.example.shoppingmall.member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Member {
    @Id
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

//    @Override
//    public String toString() {
//        return "Member{" +
//                "userId='" + userId + '\'' +
//                ", name='" + name + '\'' +
//                ", password='" + password + '\'' +
//                ", email='" + email + '\'' +
//                ", contact='" + contact + '\'' +
//                '}';
//    }
}
