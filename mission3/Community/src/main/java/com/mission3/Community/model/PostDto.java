package com.mission3.Community.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private String password;
    private Long boardId;

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", password='" + password + '\'' +
                ", boardId=" + boardId +
                '}';
    }

    public PostDto passwordMasked(){
        return new PostDto(
                this.id,
                this.title,
                this.content,
                this.writer,
                "*****",
                this.boardId);
    }
}

