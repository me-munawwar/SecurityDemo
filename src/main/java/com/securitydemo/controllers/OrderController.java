package com.securitydemo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Controller for order-related operations.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    /**
     * Creates a new order.
     *
     * @param body The details of the order.
     * @return A map containing the order ID, details, and a success message.
     */
    @PostMapping("/create")
    public Map<String, Object> createOrder(@RequestBody Map<String, Object> body) {
        Map<String, Object> response = new HashMap<>();
        response.put("orderId", UUID.randomUUID().toString());
        response.put("details", body);
        response.put("message", "Order created successfully");
        return response;
    }
}
