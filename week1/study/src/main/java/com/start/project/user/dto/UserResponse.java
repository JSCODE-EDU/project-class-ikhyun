package com.start.project.user.dto;

import com.start.project.user.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponse {

    private Long id;

    private String email;

    private LocalDateTime createdAt;


    @Builder
    public UserResponse(long id, String email, LocalDateTime createdAt){
        this.id = id;
        this.email = email;
        this.createdAt = createdAt;
    }

    public static UserResponse from(final User user){
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
