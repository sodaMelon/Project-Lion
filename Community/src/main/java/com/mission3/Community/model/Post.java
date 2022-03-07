package com.mission3.Community.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="board_id")
    private Board board;

    public Post(String title, String content, User user, Board board) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.board = board;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", board=" + board +
                "}\n";
    }
}

