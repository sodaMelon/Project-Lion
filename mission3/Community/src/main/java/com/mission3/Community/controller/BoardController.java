package com.mission3.Community.controller;

import com.mission3.Community.model.Board;
import com.mission3.Community.repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Component
@RestController
@RequestMapping("/board")
public class BoardController {
  /*  private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    private final BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @PostMapping
    public ResponseEntity<Board> createBoard(@RequestBody Board dto) {
        return ResponseEntity.ok(boardRepository.create(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<Board> readBoard(@PathVariable("id") Long id) {
        Board dto = boardRepository.read(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Collection<Board>> readAll() {
        return ResponseEntity.ok(this.boardRepository.readAll());
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateBoard(@PathVariable("id") Long id, @RequestBody Board dto) {
        if (!boardRepository.update(id, dto)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("id")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Long id, @RequestBody Board dto) {
        if (!boardRepository.delete(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }*/
}