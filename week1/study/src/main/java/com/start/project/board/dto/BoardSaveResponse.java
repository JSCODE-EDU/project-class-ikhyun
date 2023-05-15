package com.start.project.board.dto;

import lombok.Getter;

@Getter
public class BoardSaveResponse {

    private int code;

    private String message;

    public BoardSaveResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return code + ",\n " + message;
    }
}
