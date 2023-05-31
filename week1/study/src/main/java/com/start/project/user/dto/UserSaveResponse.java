package com.start.project.user.dto;

public class UserSaveResponse {

    private int code;

    private String message;

    public UserSaveResponse(int code, String message){
        this.code = code;
        this.message = message;
    }
    @Override
    public String toString() {
        return code + ",\n " + message;
    }
}
