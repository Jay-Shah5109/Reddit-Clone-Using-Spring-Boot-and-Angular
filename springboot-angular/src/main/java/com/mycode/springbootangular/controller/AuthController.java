package com.mycode.springbootangular.controller;

import com.mycode.springbootangular.dto.RegisterRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @PostMapping("/signup")
    public void signUp(@RequestBody RegisterRequest registerRequest) {

    }
}
