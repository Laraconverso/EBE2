package com.example.clase5mesa.config;

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
                .requestMatchers(HttpMethod.GET, "/test/anonymous", "/test/anonymous/*").permitAll()
                .requestMatchers(HttpMethod.GET, "/Test/admin/", "test/admin/*").hasAuthority("ROLE_app_admin")
                    //este ultimo se puede poner como has role con el rol == que aparece en el keycloak
                    //has any rolee
                    //haS Authority
                .requestMatchers(HttpMethod.GET, "/test/user/", "test/user/*").hasAnyAuthority("ROLE_app_admin","ROLE_app_user")
                .anyRequest().authenticated();
        return  null;
    }
}

