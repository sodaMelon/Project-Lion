package com.mission3.Community.repository;

import com.mission3.Community.model.Board;
import com.mission3.Community.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
/*    Board create(Board dto);
    Board read(Long id);
    Collection<Board> readAll();
    boolean update(Long id, Board dto);
    boolean delete(Long id);*/
}
