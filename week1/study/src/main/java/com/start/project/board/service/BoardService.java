package com.start.project.board.service;

import com.start.project.board.dto.BoardResponse;
import com.start.project.board.dto.BoardSaveRequest;
import com.start.project.board.dto.BoardSaveResponse;
import com.start.project.board.dto.BoardsResponse;
import com.start.project.board.entity.Board;
import com.start.project.board.repository.BoardRepository;
import com.start.project.model.code.STATUS;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.FindException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(final BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public BoardsResponse findAll(){
        List<Board> boards = boardRepository.findTop100ByOrderById();
        List<BoardResponse> boardResponses = boards.stream()
                .map(BoardResponse::from)
                .collect(Collectors.toList());
        return new BoardsResponse(boardResponses);
    }

    public BoardsResponse findByTitleSort(String title){
        List<Board> boards = boardRepository.findTop100ByTitleLikeOrderById(title);
        List<BoardResponse> boardResponses = boards.stream()
                .map(BoardResponse::from)
                .collect(Collectors.toList());
        return new BoardsResponse(boardResponses);
    }

    public BoardsResponse findAllBySearch(String keyword){
        List<Board> boards = boardRepository.findTop100ByTitleLikeOrContentLikeOrderById(keyword, keyword);
        List<BoardResponse> boardResponses = boards.stream()
                .map(BoardResponse::from)
                .collect(Collectors.toList());
        return new BoardsResponse(boardResponses);
    }

    public BoardResponse boardDetaile(Long id){
        return boardRepository.findById(id)
                .map(BoardResponse::from)
                .orElseThrow(() -> new FindException(id + "번 게시판이 없습니다."));

    }

    public BoardSaveResponse boardCreate(BoardSaveRequest boardSaveRequest){

        boardRepository.save(boardSaveRequest.toEntity());
        return  new BoardSaveResponse(STATUS.Success201.getCode(), boardSaveRequest.toEntity().toString());
    }

    public BoardSaveResponse boardUpdate(BoardSaveRequest boardSaveRequest) {
        Optional<Board> boardData = boardRepository.findById(boardSaveRequest.getId());
        boardData.orElseThrow(() ->  new FindException(new BoardSaveResponse(STATUS.Error404.getCode(),
                boardSaveRequest.getId() + "번 게시판이 없습니다.").toString()));
        boardData.ifPresent(board -> {
            board.setTitle(boardSaveRequest.getTitle());
            board.setContent(boardSaveRequest.getContent());
            boardRepository.save(board);
        });

        return  new BoardSaveResponse(STATUS.Success201.getCode(), boardSaveRequest.toString());
    }

    public void delete(Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new FindException(new BoardSaveResponse(STATUS.Error404.getCode(),
                id + "번 게시판이 없습니다.").toString()));
        boardRepository.delete(board);
    }



}
