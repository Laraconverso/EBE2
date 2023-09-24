package com.example.msusers.repository;


import com.example.msusers.domain.User;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.ws.rs.NotFoundException;


@RequiredArgsConstructor
@Repository
public class KeycloakUserRepository implements IUserRepository {


    private final Keycloak keycloak;

    @Value("${ms-users.keycloak.realm}")
    private String realm;

    public KeycloakUserRepository() {
        this.keycloak = KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080/")
                .realm("DigitalCommerce")
                .grantType("client_credentials")
                .clientId("dh-client")
                .clientSecret("b54b3PhFeELPHmssLLhH71EQqlQv5i4u")
                .build();
    }


    private User toUser(UserRepresentation userRepresentation) {
        return User.builder()
                .id(userRepresentation.getId())
                .userName(userRepresentation.getUsername())
                .email(userRepresentation.getEmail())
                .firstName(userRepresentation.getFirstName())
                .lastName(userRepresentation.getLastName())
                .build();
    }


    @Override
    public User findById(String id) {
        UserRepresentation userRepresentation;

        try {
            userRepresentation = keycloak.realm(realm)
                    .users().get(id)
                    .toRepresentation();

        } catch (NotFoundException e) {
            throw new NotFoundException("User not found");
        }
        return toUser(userRepresentation);

    }



}