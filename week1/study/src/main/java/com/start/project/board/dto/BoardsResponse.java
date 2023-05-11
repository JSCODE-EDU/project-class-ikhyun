package com.start.project.board.dto;

import lombok.Getter;

import java.util.List;

@Getter

public class BoardsResponse {

    private List<BoardResponse> boards;

    public BoardsResponse(List<BoardResponse> boards){
        this.boards = boards;
    }
}
