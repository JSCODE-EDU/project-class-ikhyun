package com.start.project.model.code;

import lombok.Getter;

@Getter
public enum STATUS {

    Error404(404, ""),
    Success201(200, "성공적으로 저장이 되었습니다.");



    private int code;
    private String description;

    STATUS(int code, String description) {
        this.code =code;
        this.description = description;
    }
}
