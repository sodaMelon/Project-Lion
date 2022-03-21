package dev.aquashdw.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String goHome(@RequestParam("likelion_login_cookie") String lionCookie){
        return "login-form";
    }

    @GetMapping("/request-login")
    public String make(@RequestParam("request_from") String lastLocation,
                       HttpServletResponse response,
                       Model model){

        Cookie cookie = new Cookie("likelion_login_cookie", "sample-text");
        cookie.setMaxAge(36000);
        response.addCookie(cookie);

        return "redirect:/home?likelion_login_cookie="+cookie.getValue();
    }

}
