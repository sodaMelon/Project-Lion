package project.lion.mission2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Post {
    private int id; //Primary Key
    private String board; // 게시판 이름 정보
    private String title; // 제목
    private String content; // 본문
    private String writer; // 작성자

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password; // 비밀번호

    public void setBoard(String board) {
        this.board = board;
    }
}
