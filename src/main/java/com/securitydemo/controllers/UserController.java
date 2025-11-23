package com.securitydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller for user-related operations.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * Retrieves the profile of the currently authenticated user.
     *
     * @return A map containing the user's name and role.
     */
    @GetMapping("/profile")
    public Map<String, String> profile() {
        Map<String, String> res = new HashMap<>();
        res.put("name", "Munawwar");
        res.put("role", "USER");
        return res;
    }
}
