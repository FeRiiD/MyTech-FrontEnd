package com.example.commentservice;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class AuthorizationConfig {
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(authorize -> authorize
//                .requestMatchers(HttpMethod.GET, "/**").permitAll()
//                .requestMatchers(HttpMethod.POST, "/articles").authenticated())
//                .oauth2ResourceServer((oauth2) -> oauth2
//                .jwt(Customizer.withDefaults()));
//
//        return httpSecurity.build();
//    }
//}
