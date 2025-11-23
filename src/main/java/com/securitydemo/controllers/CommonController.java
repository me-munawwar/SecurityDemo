package com.securitydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller for common endpoints accessible to both users and admins.
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    /**
     * Retrieves information about the application.
     *
     * @return A map containing the application name and status.
     */
    @GetMapping("/info")
    public Map<String, String> info() {
        Map<String, String> res = new HashMap<>();
        res.put("app", "Spring Security Practice API");
        res.put("status", "running");
        return res;
    }
}
