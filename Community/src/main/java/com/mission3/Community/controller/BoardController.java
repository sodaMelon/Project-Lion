package com.mission3.Community.controller;
import com.mission3.Community.model.Board;
import com.mission3.Community.repository.BoardRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("/make-default-board")
    public String makeDefaultBoards() {
        boardRepository.save(new Board("notice"));
        boardRepository.save(new Board("free-board"));
        boardRepository.save(new Board("book-review"));
        boardRepository.save(new Board("contact"));
        return boardRepository.findAll().toString() + "게시판이 생성되었습니다.";
    }
}