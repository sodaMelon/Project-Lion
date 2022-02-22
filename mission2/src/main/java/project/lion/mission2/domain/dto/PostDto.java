package project.lion.mission2.domain.dto;

import lombok.Getter;

@Getter
public class PostDto {
    private String board;
    private String title;
    private String content;
    private String writer;
    private String password;
}
