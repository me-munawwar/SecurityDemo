package com.securitydemo.service;

import com.securitydemo.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * A custom authentication provider that authenticates users against the database.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final CustomUserSevice userService;

    /**
     * Authenticates the user.
     *
     * @param authentication The authentication request object.
     * @return An authenticated {@link Authentication} object.
     * @throws AuthenticationException If authentication fails.
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String rawPassword = authentication.getCredentials().toString();
        log.info("authentication attempted for userName : {}", username);
        Optional<User> optionalUser = userService.findByEmail(username);
        if (optionalUser.isPresent()) {
            User u = optionalUser.get();
            log.info("user found in the database : {}", u);
            if (!u.getPassword().equals(rawPassword)) {
                log.info("Bad credential exception");
                throw new BadCredentialsException("Invalid Credentials");
            }
            return new UsernamePasswordAuthenticationToken(username, rawPassword, List.of(new SimpleGrantedAuthority("ROLE_USER")));
        }

        log.info("user not found exception : {}", username);
        throw new RuntimeException("User could not be found");
    }

    /**
     * Returns true if this {@link AuthenticationProvider} supports the indicated
     * {@link Authentication} object.
     *
     * @param authenticationType The type of authentication object.
     * @return True if the provider supports the authentication type, false otherwise.
     */
    @Override
    public boolean supports(Class<?> authenticationType) {
        return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
    }
}
