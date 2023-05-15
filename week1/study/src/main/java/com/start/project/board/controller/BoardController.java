package com.start.project.board.controller;

import com.start.project.board.dto.BoardResponse;
import com.start.project.board.dto.BoardSaveRequest;
import com.start.project.board.dto.BoardSaveResponse;
import com.start.project.board.dto.BoardsResponse;
import com.start.project.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }
    @GetMapping("")
    public BoardsResponse findAll(@RequestParam(name = "title", required = false) String title){
        if(title.isEmpty()) {
            return boardService.findAll();
        }else{
           return  boardService.findByTitleSort(title);
        }
    }

    @GetMapping("/{id}")
    public BoardResponse findByIdBoard(@PathVariable("id") Long id){
        return boardService.boardDetaile(id);
    }

    @PostMapping("")
    public BoardSaveResponse boardCreate(BoardSaveRequest boardSaveRequest){
        return boardService.boardCreate(boardSaveRequest);
    }

    @PatchMapping("")
    public BoardSaveResponse boardUpdate(BoardSaveRequest boardSaveRequest){
        return boardService.boardUpdate(boardSaveRequest);
    }

}
