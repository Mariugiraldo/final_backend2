package com.example.msusers.configuration;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class KeyCloakSecurityConfig {

    @Bean
    Keycloak keycloak(@Value("${spring.security.oauth2.client.registration.keycloak.server-url}") String serverUrl) {
        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm("master") // admin rest-api
                .clientId("admin-cli")
                .username("admin")
                .password("admin")
                .grantType(OAuth2Constants.PASSWORD)
                .build();
    }
}