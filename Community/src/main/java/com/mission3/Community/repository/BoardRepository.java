package com.mission3.Community.repository;

import com.mission3.Community.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByName(String name);
}
