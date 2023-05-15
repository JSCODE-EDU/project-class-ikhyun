package com.start.project.board.repository;

import com.start.project.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository  extends JpaRepository<Board, Long> {

    @Query("SELECT B FROM Board B ORDER BY B.id DESC LIMIT 100")
    List<Board> findAllSort();
    @Query("SELECT B FROM Board B WHERE B.title = :title ORDER BY B.id DESC LIMIT 100")
    List<Board> findByTitleSort(String title);
}
