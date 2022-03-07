package com.mission3.Community.controller;

import com.mission3.Community.model.Board;
import com.mission3.Community.model.Post;
import com.mission3.Community.model.User;
import com.mission3.Community.model.dto.PostDto;
import com.mission3.Community.repository.BoardRepository;
import com.mission3.Community.repository.PostRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Component
@RestController
@RequestMapping("/board")
public class PostController {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    public PostController(PostRepository postRepository, BoardRepository boardRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
    }

    @PostMapping("/write")
    public String writePost(@RequestBody PostDto postDto, HttpSession session){
        User user = (User) session.getAttribute("loginUser");
        Board board = boardRepository.findByName(postDto.getBoardName());
        postRepository.save(new Post(postDto.getTitle(), postDto.getContent(), user, board ));

        return postRepository.findAll().toString();
    }
}
