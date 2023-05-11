package com.start.project.board.dto;

import com.start.project.board.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponse {

    private Long id;
    private String title;
    private String content;

    @Builder
    public BoardResponse(long id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static BoardResponse from(final Board board){
        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }
}
