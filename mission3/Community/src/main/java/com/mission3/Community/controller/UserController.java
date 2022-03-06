package com.mission3.Community.controller;

import com.mission3.Community.model.User;
import com.mission3.Community.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/make-test")
    public String makeDummyUser(){
        User user1 = new User("user1","1234");
        userRepository.save(user1);
        User user2 = new User("user2","2234");
        userRepository.save(user2);
        return "생성 완료";
    }

    @GetMapping("/read-test")
    public String readAll(){
        List<User> usersList= userRepository.findAll();
        return usersList.toString();
    }

}
