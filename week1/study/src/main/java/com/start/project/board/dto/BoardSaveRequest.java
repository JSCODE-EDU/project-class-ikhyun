package com.start.project.board.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardSaveRequest {

    private Long id;
    private String title;
    private String content;

    @Builder
    public BoardSaveRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Builder
    public BoardSaveRequest(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


}
