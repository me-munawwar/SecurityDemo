package com.securitydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/profile")
    public Map<String, String> profile() {
        Map<String, String> res = new HashMap<>();
        res.put("name", "Munawwar");
        res.put("role", "USER");
        return res;
    }
}
