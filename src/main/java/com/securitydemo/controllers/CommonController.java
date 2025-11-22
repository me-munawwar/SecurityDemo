package com.securitydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/common")
public class CommonController {

    @GetMapping("/info")
    public Map<String, String> info() {
        Map<String, String> res = new HashMap<>();
        res.put("app", "Spring Security Practice API");
        res.put("status", "running");
        return res;
    }
}
