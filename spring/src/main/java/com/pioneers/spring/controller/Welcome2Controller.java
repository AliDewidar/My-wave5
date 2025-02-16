package com.pioneers.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome2")
public class Welcome2Controller {

    @GetMapping(value = "welcome")
    public String welcomeApi() {
        return "Welcome to Tech Pioneers Hub with Spring Boot";
    }

    @GetMapping("ali")
    public String welcomeAliApi() {
        return "<h1>Welcome2 Ali to Tech Pioneers Hub with Spring Boot<h1>";
    }
}
