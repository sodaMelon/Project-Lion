package com.mission3.Community.controller;

import com.mission3.Community.model.Post;
import com.mission3.Community.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Component
@RestController
@RequestMapping("board/{boardId}/post")
public class PostController {
/*    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostRepository postRepository;

    public PostController(@Autowired PostRepository postRepository) {
        this.postRepository =postRepository;
    }

    @PostMapping
    public ResponseEntity<Post> creatPost(
            @PathVariable("boardId") Long boardId, @RequestBody Post dto) {
        Post result = this.postRepository.create(boardId, dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("{postId}")
    public ResponseEntity<Post> readPost(
            @PathVariable("boardId") Long boardId,
            @PathVariable("postId") Long postId) {
        Post post = this.postRepository.read(boardId,postId);
        if (post == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(post);
    }

    @GetMapping
    public ResponseEntity<Collection<Post>> readPostAll(
            @PathVariable("boardId") Long boardId,
            @PathVariable("postId") Long postId) {
        Collection<Post> postList = this.postRepository.readAll(boardId);
        if (postList == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(postList);
    }

    @PutMapping("{postId}")
    public ResponseEntity<?> updatePost(
            @PathVariable("boardId") Long boardId,
            @PathVariable("postId") Long postId,
            @RequestBody Post dto) {
        if (!postRepository.update(boardId,postId,dto))
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<?> deletePost(
            @PathVariable("boardId") Long boardId,
            @PathVariable("postId") Long postId,
            @RequestParam("password") String password) {
        if (!postRepository.delete(boardId,postId,password))
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }*/
}
