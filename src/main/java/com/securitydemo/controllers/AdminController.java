package com.securitydemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for admin-related operations.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    /**
     * Retrieves the admin dashboard.
     *
     * @return A string indicating that the admin dashboard has loaded.
     */
    @GetMapping("/dashboard")
    public String dashboard() {
        return "Admin dashboard loaded.";
    }
}
