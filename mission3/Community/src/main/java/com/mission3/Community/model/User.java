package com.mission3.Community.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String writer;
    private String password;

    public User(String writer, String password) {
        this.writer = writer;
        this.password = password;
    }
}
