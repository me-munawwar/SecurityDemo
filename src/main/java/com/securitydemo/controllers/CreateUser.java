package com.securitydemo.controllers;

import com.securitydemo.model.User;
import com.securitydemo.service.CustomUserSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for creating new users.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class CreateUser {
    private final CustomUserSevice customUserSevice;

    /**
     * Creates a new user.
     *
     * @param user The user to create.
     * @return The created user.
     */
    @PostMapping(path = "/create")
    public User createUser(@RequestBody User user) {
        return customUserSevice.save(user);
    }
}
