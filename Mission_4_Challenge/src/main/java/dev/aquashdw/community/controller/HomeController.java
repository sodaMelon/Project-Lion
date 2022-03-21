package dev.aquashdw.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/test")
    public String goHome(){
        return "index";
    }
    @GetMapping("/make-cookie")
    public String make(HttpServletResponse response){
        Cookie cookie = new Cookie("likelion_login_cookie", "sample");
        cookie.setMaxAge(36000);

        response.addCookie(cookie);
        return "login";
    }

}
