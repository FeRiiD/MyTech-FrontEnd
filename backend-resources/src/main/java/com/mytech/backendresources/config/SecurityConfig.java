package com.mytech.backendresources.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
    /**
     * For the backend-resources, I indicate that all the endpoints are protected.
     * To request any endpoint, the OAuth2 protocol is necessary, using the server configured and with the given scope.
     * Thus, a JWT will be used to communicate between the backend-resources and backend-auth when backend-resources
     * needs to validate the authentication of a request.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //http.authorizeHttpRequests().requestMatchers("/**").access("hasAuthority('SCOPE_message.read')").and().oauth2ResourceServer().jwt();
        http.authorizeHttpRequests(authorize -> authorize
                // Get request can be executed by every unauthorized user with any specific endpoint
                .requestMatchers(HttpMethod.GET, "/**").permitAll()
                // When posting a article the user has to be authenticated.
                .requestMatchers(HttpMethod.POST, "/articles").authenticated())
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }
}
