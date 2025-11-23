package com.securitydemo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serializable;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleBadCredentials(BadCredentialsException ex) {
        Map<String, ? extends Serializable> status = Map.of("status", 500, "message", ex.getMessage());
        return ResponseEntity.ok(status);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Object> handleUserNameNotFound(UsernameNotFoundException ex) {
        Map<String, ? extends Serializable> status = Map.of("status", 500, "message", ex.getMessage());
        return ResponseEntity.ok(status);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        Map<String, ? extends Serializable> status = Map.of("status", 500, "message", ex.getMessage());
        return ResponseEntity.ok(status);
    }

}
