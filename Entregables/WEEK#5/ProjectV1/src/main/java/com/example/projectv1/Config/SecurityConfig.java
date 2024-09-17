package com.example.projectv1.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) 
            .authorizeHttpRequests(auth -> auth
                // Definir primero las reglas más específicas
                .requestMatchers("/accounts/**").hasAnyRole("USER", "ADMIN") // Protect these endpoints for users and administrators
                .requestMatchers("/api/transactions/**").hasRole("ADMIN") // Only accessible by administrators.
                // Then, allow any other request.
                .anyRequest().permitAll()  //Allow public access to other endpoints.
            )
            .httpBasic(withDefaults()); // Use basic authentication

        return http.build();
    }

    @Bean
public UserDetailsService userDetailsService() {
    UserDetails user = User.withUsername("user")
        .password("{noop}password")
        .roles("USER")
        .build();

    UserDetails admin = User.withUsername("admin")
        .password("{noop}admin")
        .roles("ADMIN")
        .build();

    return new InMemoryUserDetailsManager(user, admin);
}
}