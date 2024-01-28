package com.example.medical.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class LoginController {

    @GetMapping
    public String getMainPage() {
        return "main";
    }

    @GetMapping("index")
    public String getIndexPage() {
        return "index";
    }
}
