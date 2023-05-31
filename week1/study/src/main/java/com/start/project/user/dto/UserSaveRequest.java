package com.start.project.user.dto;

import com.start.project.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class UserSaveRequest {


    private  String email;

    private String password;

    @Builder
    public UserSaveRequest(String email, String password){
        this.email = email;
        this.password = password;
    }

    public User toEntity(){
        return User.builder()
                .email(this.email)
                .password(this.password)
                .build();
    }

}
