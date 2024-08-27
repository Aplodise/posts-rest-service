package com.roman.restapi.controller;


import com.roman.restapi.config.LoginCredentials;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials loginCredentials){

    }

    @GetMapping("/secured")
    public String secured(){
        return "secured";
    }
}
