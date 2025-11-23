package com.securitydemo.controllers;

import com.securitydemo.model.User;
import com.securitydemo.service.CustomUserSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class CreateUser {
    private final CustomUserSevice customUserSevice;

    @PostMapping(path = "/create")
    public User createUser(@RequestBody User user) {
        return customUserSevice.save(user);
    }
}
