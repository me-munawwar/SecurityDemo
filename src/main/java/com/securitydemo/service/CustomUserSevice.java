package com.securitydemo.service;

import com.securitydemo.model.User;
import com.securitydemo.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service for managing users.
 */
@Service
@RequiredArgsConstructor
public class CustomUserSevice {

    private final UserRepository userRepository;

    /**
     * Finds a user by their email address.
     *
     * @param email The email address to search for.
     * @return An {@link Optional} containing the user if found, or empty otherwise.
     */
    public Optional<User> findByEmail(String email) {
        return userRepository.findUserByUserName(email);
    }

    /**
     * Saves a user to the database.
     *
     * @param u The user to save.
     * @return The saved user.
     */
    public User save(User u) {
        return userRepository.save(u);
    }
}
