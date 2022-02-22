package project.lion.mission2.controller;

import org.springframework.web.bind.annotation.*;
import project.lion.mission2.domain.Post;
import project.lion.mission2.domain.dto.PostDto;

import java.util.ArrayList;
import java.util.List;

@ResponseBody
@RestController
public class BasicController {

    private List<Post> postList;

    public BasicController(){
        this.postList = new ArrayList<>();
    }


    @PostMapping("/make-new-post")
    public String make(@RequestBody PostDto postDto) {

        Post newPost = new Post().builder()
                .board(postDto.getBoard())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .writer(postDto.getWriter())
                .password(postDto.getPassword())
                .build();
        postList.add(newPost);
        System.out.println(postList);

        int postNumber = postList.size()-1;
        return "글번호 [" + postNumber + "]로 게시글이 작성되었습니다.";

    }

    @GetMapping("/list") //전체 읽기
    public List<Post> readAllPost() {
        return this.postList;
    }

    @GetMapping("/post/{id}") //특정 글번호 읽기
    public Post read(@PathVariable ("id") int id) {
        return this.postList.get(id);
    }

    @PutMapping("/update/{id}") //특정 글번호 게시판 변경하기,
    public Post update(@PathVariable ("id") int id, @PathVariable ("board") String newBoard) {
        Post targetPost = postList.get(id);
        targetPost.setBoard(newBoard);
        postList.set(id, targetPost);
        return this.postList.get(id);
    }

    @PutMapping("/delete/{id}") //특정 글번호 게시판 변경하기,
    public String delete(@PathVariable ("id") int id, @PathVariable ("password") String password) {
        Post targetPost = postList.get(id);
        if (! targetPost.getPassword().equals(password) ) {
            return "삭제 실패";
        }
        return "삭제 성공";
    }

}
