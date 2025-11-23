package com.securitydemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configures the security settings for the application.
 * <p>
 * This class is annotated with {@link Configuration} to indicate that it's a source
 * of bean definitions. {@link EnableWebSecurity} enables Spring Security's web security
 * support.
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    /**
     * Defines the security filter chain that applies to all HTTP requests.
     *
     * @param http The {@link HttpSecurity} to configure.
     * @return The configured {@link SecurityFilterChain}.
     * @throws Exception If an error occurs during configuration.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("Control in security filter chain");
        http
                // Disable CSRF protection, as it's not needed for this stateless API.
                .csrf(AbstractHttpConfigurer::disable)
                // Configure authorization rules for different endpoints.
                .authorizeHttpRequests(auth -> auth
                        // Allow all requests to public endpoints.
                        .requestMatchers("/public/**").permitAll()
                        // Allow users with the "USER" role to access their profile.
                        .requestMatchers("/user/profile").hasRole("USER")
                        // Allow anyone to create a new user.
                        .requestMatchers("/user/create").permitAll()
                        // Restrict admin endpoints to users with the "ADMIN" role.
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        // Allow users with "USER" or "ADMIN" roles to access common endpoints.
                        .requestMatchers("/common/**").hasAnyRole("USER", "ADMIN")
                        // Require authentication for all order-related endpoints.
                        .requestMatchers("/orders/**").authenticated()
                        // Require authentication for all other requests.
                        .anyRequest().authenticated()
                )
                // Enable HTTP Basic authentication with default settings.
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
