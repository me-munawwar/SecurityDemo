package com.securitydemo.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomUserStore {

    private final Map<String, String> userPasswordMap = new HashMap<>();
    private final Map<String, List<SimpleGrantedAuthority>> userAuthoritiesMap = new HashMap<>();

    public CustomUserStore() {

        // --- Passwords ---
        userPasswordMap.put("munna", "12345");
        userPasswordMap.put("john", "pass123");
        userPasswordMap.put("alice", "alice321");

        // --- Authorities ---
        userAuthoritiesMap.put("munna", List.of(
                new SimpleGrantedAuthority("ROLE_USER")
        ));

        userAuthoritiesMap.put("john", List.of(
                new SimpleGrantedAuthority("ROLE_USER")
        ));

        userAuthoritiesMap.put("alice", List.of(
                new SimpleGrantedAuthority("ROLE_MANAGER"),
                new SimpleGrantedAuthority("WRITE_PRIVILEGE")
        ));
    }

    public String getPassword(String username) {
        return userPasswordMap.get(username);
    }

    public List<SimpleGrantedAuthority> getAuthorities(String username) {
        return userAuthoritiesMap.get(username);
    }

    public boolean exists(String username) {
        return userPasswordMap.containsKey(username);
    }
}
