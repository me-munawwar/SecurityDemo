package com.securitydemo.service;

import com.securitydemo.model.User;
import com.securitydemo.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserSevice {

    private final UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findUseByUserName(email);
    }

    public User save(User u) {
        return userRepository.save(u);
    }
}
