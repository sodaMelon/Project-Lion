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
    private int idCursor = -1;

    public BasicController(){
        this.postList = new ArrayList<>();
    }

    @PostMapping("/make-new-post")//새 게시글 쓰기(create)
    public String make(@RequestBody PostDto postDto) {
        idCursor++;
        Post newPost = new Post().builder()
                .id(idCursor)
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

    @GetMapping("/") //전체 게시글 읽기
    public List<Post> readAllPost() {
        return this.postList;
    }

    @GetMapping("/{board}") //특정 게시판 읽기
    public List<Post> selectPostByBoard(@PathVariable ("board") String targetBoard){
        List<Post> matchedByBoard = new ArrayList<>();
        for(Post post: postList){
            if (post.getBoard().equals( targetBoard)){
                matchedByBoard.add(post);
            }
        }
        return matchedByBoard;
    }

    @GetMapping("/post/{id}") //특정 글번호 읽기
    public Post readOnePost(@PathVariable ("id") int id) {
        return this.postList.get(id);
    }

    @PutMapping("/update/{id}") //특정 글번호로 게시판 변경하기(update)
    public Post moveAnotherBoard(@PathVariable ("id") String id, @RequestBody String newBoard) {
        int idNumber = Integer.parseInt(id);
        Post targetPost = postList.get(idNumber);
        targetPost.setBoard(newBoard);
        postList.set(idNumber, targetPost);
        return this.postList.get(idNumber);
    }

    @DeleteMapping("/delete/{id}") //특정 글번호로 해당 게시글 삭제하기(delete)
    public String delete(@PathVariable ("id") int id, @RequestBody String password) {
        Post targetPost = postList.get(id);
        if (! targetPost.getPassword().equals(password) ) {
            return "삭제 실패, 비밀번호가 틀립니다";
        }
        postList.remove(id);
        return "삭제 성공";
    }

}
