package org.camilogo1200.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/actuator/**", "/assets/**").permitAll()
            .requestMatchers("/welcome").authenticated()   // protect /welcome to trigger OIDC login
            .anyRequest().permitAll()
        )
        .oauth2Login(Customizer.withDefaults())          // enables /oauth2/authorization/keycloak
        .oauth2Client(Customizer.withDefaults())
        .logout(logout -> logout.logoutSuccessUrl("/")); // optional logout landing

    return http.build();
  }
}