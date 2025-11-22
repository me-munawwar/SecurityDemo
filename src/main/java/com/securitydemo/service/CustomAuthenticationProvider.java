package com.securitydemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final CustomUserStore userStore;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String rawPassword = authentication.getCredentials().toString();

        String storedPassword = userStore.getPassword(username);

        if (storedPassword == null)
            throw new BadCredentialsException("User does not exist!");

        if (!storedPassword.equals(rawPassword))
            throw new BadCredentialsException("Invalid password!");

        // Success → return authenticated token
        return new UsernamePasswordAuthenticationToken(
                username,
                rawPassword,
                userStore.getAuthorities(username)   // No roles for simplicity; you can add authorities here
        );
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
    }
}
