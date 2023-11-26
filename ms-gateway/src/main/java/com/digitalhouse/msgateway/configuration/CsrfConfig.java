package com.digitalhouse.msgateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class CsrfConfig {
    @Bean
    public SecurityWebFilterChain disableCsrfFilterChain(ServerHttpSecurity http) {
        http.csrf(csrfSpec -> csrfSpec.disable());
        return http.build();
    }
}
