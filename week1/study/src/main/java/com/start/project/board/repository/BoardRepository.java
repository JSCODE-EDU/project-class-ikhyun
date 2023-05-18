package com.start.project.board.repository;

import com.start.project.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface BoardRepository  extends JpaRepository<Board, Long> {

    List<Board> findTop100ByOrderById();
    List<Board> findTop100ByTitleContainsOrderById(String title);
    List<Board> findTop100ByTitleContainsOrContentContainsOrderById(String keyword1, String keyword2);
}
