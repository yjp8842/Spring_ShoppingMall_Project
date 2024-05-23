package com.example.shoppingmall.member;
import com.example.shoppingmall.member.MemberDto.MemberSignUpDto;
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

    public static Member fromDtoToEntity(MemberSignUpDto memberSignUpDto) {
        return new Member(
                memberSignUpDto.getUserId(),
                memberSignUpDto.getName(),
                memberSignUpDto.getPassword(),
                memberSignUpDto.getEmail(),
                memberSignUpDto.getContact()
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
