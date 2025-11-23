package com.securitydemo.repo;

import com.securitydemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for managing {@link User} entities.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * Finds a user by their username.
     *
     * @param userName The username to search for.
     * @return An {@link Optional} containing the user if found, or empty otherwise.
     */
    Optional<User> findUserByUserName(String userName);
}
