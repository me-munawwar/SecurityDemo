package com.securitydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for public endpoints accessible to everyone.
 */
@RestController
@RequestMapping("/public")
public class PublicController {

    /**
     * Returns a welcome message.
     *
     * @return A welcome message.
     */
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the public API!";
    }
}
