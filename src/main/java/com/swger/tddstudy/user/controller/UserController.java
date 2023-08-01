package com.swger.tddstudy.user.controller;

import com.swger.tddstudy.user.domain.UserVO;
import com.swger.tddstudy.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @GetMapping("join-form")
    public String joinForm() {
        return "userPages/join";
    }

    @GetMapping("/login-form")
    public String loginForm() throws Exception {
        return "userPages/login";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserVO userVO) {
        userService.save(userVO);
        return "userPages/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserVO userVO, HttpSession session) {
        UserVO loginResult = userService.login(userVO);
        if (loginResult != null) {
            session.setAttribute("username", loginResult.getUsername());
            session.setAttribute("id", loginResult.getId());
            return "main";
        } else {
            return "userPages/login";
        }
    }

}