package com.start.project.board.controller;

import com.start.project.board.dto.BoardResponse;
import com.start.project.board.dto.BoardSaveRequest;
import com.start.project.board.dto.BoardSaveResponse;
import com.start.project.board.dto.BoardsResponse;
import com.start.project.board.service.BoardService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "게시글 전체 조회", notes = "query parameter 로 title을 추가하면 제목을 관련된것을 조회 할수 있다.")
    @GetMapping("")
    public BoardsResponse findAll(@RequestParam(name = "title", required = false) String title){
        if(title == null || title.isEmpty()) {
            return boardService.findAll();
        }else{
           return  boardService.findByTitleSort(title);
        }
    }

    @ApiOperation(value = "특정 게시글 조회")
    @GetMapping("/{id}")
    public BoardResponse findByIdBoard(@PathVariable("id") Long id){
        return boardService.boardDetaile(id);
    }

    @ApiOperation(value = "게시글 검색")
    @GetMapping("/search")
    public BoardsResponse findAllBySearch(@RequestParam(name = "keyword") String keyword){
        return boardService.findAllBySearch(keyword);
    }

    @ApiOperation(value = "게시글 작성")
    @PostMapping("")
    public BoardSaveResponse boardCreate(@RequestBody BoardSaveRequest boardSaveRequest){
        log.info("boardSaveRequest: " +boardSaveRequest.toString());
        return boardService.boardCreate(boardSaveRequest);
    }

    @ApiOperation(value = "게시글 수정")
    @PatchMapping("")
    public BoardSaveResponse boardUpdate(@RequestBody BoardSaveRequest boardSaveRequest){
        return boardService.boardUpdate(boardSaveRequest);
    }

    @ApiOperation(value = "게시글 삭제")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        boardService.delete(id);
        return id + "번이 정상적으로 삭제 되었습니다.";
    }

}
