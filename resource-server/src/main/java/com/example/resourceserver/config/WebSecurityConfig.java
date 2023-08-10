package com.example.resourceserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new JwtAuthConverter());

        http.authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/test/anonymuous", "/test/anonymuous/*").permitAll()
                .requestMatchers(HttpMethod.GET, "/test/admin/", "test/admin/*").hasAuthority("ROLE_app_admin")
                .requestMatchers(HttpMethod.GET, "test/user/", "test/user/*").hasAnyAuthority("ROLE_app_admin", "ROLE_app_user")
                .anyRequest().authenticated();
        http.oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthenticationConverter);

        return http.build();
    }
}
