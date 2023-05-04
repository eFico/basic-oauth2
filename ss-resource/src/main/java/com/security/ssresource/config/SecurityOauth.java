package com.security.ssresource.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityOauth {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.oauth2ResourceServer()
        .opaqueToken()
        .introspectionUri("http://localhost:8080/oauth2/introspect")
        .introspectionClientCredentials("client" ,"secret");

    http.authorizeHttpRequests()
        .anyRequest().authenticated();

    return http.build();
  }
}