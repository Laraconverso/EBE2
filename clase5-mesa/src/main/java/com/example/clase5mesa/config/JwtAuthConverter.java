package com.example.clase5mesa.config;


import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtAuthConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt source){

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Map<String , Object> realmAccessRoles = (Map<String, Object>) source.getClaims().get("realm_access");
        if(realmAccessRoles != null && !realmAccessRoles.isEmpty()){
            authorities.addAll(extractRoles(realmAccessRoles));

        }

        return null;

    }

    private static Collection<GrantedAuthority> extractRoles(Map<String, Object> realmAccesRoles){
        return ((List<String>)realmAccesRoles.get("roles"))
                .stream().map(roleMap->"ROLE_" + roleMap)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}
