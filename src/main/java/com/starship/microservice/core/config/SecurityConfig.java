package com.starship.microservice.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**").permitAll()
                        .anyExchange().authenticated()
                )
                .formLogin(withDefaults())
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .build();
    }
}

