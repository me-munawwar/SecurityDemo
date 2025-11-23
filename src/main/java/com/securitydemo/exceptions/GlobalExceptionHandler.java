package com.securitydemo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serializable;
import java.util.Map;

/**
 * Global exception handler for the application.
 * This class handles exceptions thrown by controllers and returns appropriate HTTP responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles {@link BadCredentialsException} and returns a 500 Internal Server Error response.
     *
     * @param ex The exception to handle.
     * @return A response entity with a status of 500 and the exception message.
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleBadCredentials(BadCredentialsException ex) {
        Map<String, ? extends Serializable> status = Map.of("status", 500, "message", ex.getMessage());
        return ResponseEntity.ok(status);
    }

    /**
     * Handles {@link UsernameNotFoundException} and returns a 500 Internal Server Error response.
     *
     * @param ex The exception to handle.
     * @return A response entity with a status of 500 and the exception message.
     */
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Object> handleUserNameNotFound(UsernameNotFoundException ex) {
        Map<String, ? extends Serializable> status = Map.of("status", 500, "message", ex.getMessage());
        return ResponseEntity.ok(status);
    }

    /**
     * Handles generic {@link RuntimeException} and returns a 500 Internal Server Error response.
     *
     * @param ex The exception to handle.
     * @return A response entity with a status of 500 and the exception message.
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        Map<String, ? extends Serializable> status = Map.of("status", 500, "message", ex.getMessage());
        return ResponseEntity.ok(status);
    }

}
