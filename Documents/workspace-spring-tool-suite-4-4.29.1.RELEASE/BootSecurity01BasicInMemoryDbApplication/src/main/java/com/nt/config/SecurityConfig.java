package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
            	.requestMatchers("/").permitAll() // Allow access to the root URL
            	.requestMatchers("/resources/**").permitAll()
                .requestMatchers("/offers").authenticated()
                .requestMatchers("/balance").hasAnyRole("CUSTOMER", "ADMIN")
                .requestMatchers("/loan").hasRole("ADMIN")
                .requestMatchers("/loanStatus").hasRole("ADMIN")
                .anyRequest().authenticated() // All other requests require authentication
            )
            .formLogin(form -> form
                .defaultSuccessUrl("/home", true) // Redirect to home after login
                .permitAll()
            )
            .exceptionHandling(ex -> ex
                .accessDeniedPage("/BootSecurity/denied")
            )
            .csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = passwordEncoder();
        return new InMemoryUserDetailsManager(
            User.withUsername("user")
                .password(encoder.encode("password"))
                .roles("CUSTOMER")
                .build(),
            User.withUsername("shivam")
                .password(encoder.encode("shivam"))
                .roles("ADMIN")
                .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}