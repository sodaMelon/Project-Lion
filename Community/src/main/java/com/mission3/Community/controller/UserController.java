package com.mission3.Community.controller;

import com.mission3.Community.model.User;
import com.mission3.Community.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Component
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/join") //Create
    public String makeUser(@RequestParam String writer,
                           @RequestParam String password) {
        User user1 = new User(writer, password);
        userRepository.save(user1);
        return "생성 완료";
    }

    @GetMapping("/login") //Read
    public String login(@RequestParam String writer,
                        @RequestParam String password,
                        HttpSession session) {
        User loginUser = userRepository.findByWriterAndPassword(writer, password);
        session.setAttribute("loginUser", loginUser);
        if (loginUser == null) {
            return "로그인 실패, 입력하신 값을 확인해주세요";
        }
        return loginUser.toString() + "정보로 로그인에 성공했습니다.(세션에 정보 저장됨)";
    }

    @GetMapping("/find-all-user") //Read
    public String findAllUser() {
        return "현재 가입한유저들\n"+ userRepository.findAll().toString();
    }

    @PutMapping("/change-password") //update
    public String changePassword(@RequestParam String writer,
                                 @RequestParam String password,
                                 @RequestParam String newPassword) {
        User targetUser = userRepository.findByWriterAndPassword(writer, password);
        targetUser.setPassword(newPassword);
        userRepository.save(targetUser);

        return targetUser.toString() + "로 정보가 변경되었습니다.";
    }

    @DeleteMapping("/delete-account") //delete
    public String deleteAccount(@RequestParam String writer,
                                @RequestParam String password) {
        User targetUser = userRepository.findByWriterAndPassword(writer, password);
        userRepository.delete(targetUser);
        List<User> userList = userRepository.findAll();
        return writer + "계정 삭제완료\n 현재 저장된 유저 목록:" + userList.toString();
    }

}
