package com.example.keycloaklocal.repository;

import com.example.keycloaklocal.model.User;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class KeyclaokUserRepository implements IUserRepository{

    private final Keycloak keyclaokClient;
    @Value("${dh.keycloak.realm}")
    private String realm;
    @Override
    public List<User> findAll() {

        return keyclaokClient.realm(realm).users().list().stream().map(this::toUser).collect(Collectors.toList());

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
    public List<User> findByFirstName(String firstName) {
        List<UserRepresentation> userRepresentation = keyclaokClient
                .realm(realm)
                .users()
                .search(firstName);
        return userRepresentation.stream().map(user ->
                fromRepresentation(user)).collect(Collectors.toList());
    }



    @Override
    public Optional<User> findById(String id) {
        UserRepresentation userRepresentation;
        try {
            userRepresentation = keyclaokClient.realm(realm)
                    .users().get(id)
                    .toRepresentation();
        } catch (NotFoundException e) {
            return Optional.empty();
        }
        return Optional.of(toUser(userRepresentation));

    }

    @Override
    public User deleteUserById(String id) {
        UserRepresentation userRepresentation;
        try {
            userRepresentation = keyclaokClient.realm(realm)
                    .users().get(id)
                    .toRepresentation();
        } catch (NotFoundException e) {
            return null;
        }
        keyclaokClient.realm(realm).users().delete(id);
        return toUser(userRepresentation);
    }


    private User fromRepresentation (UserRepresentation userRepresentation) {
        return new User(userRepresentation.getId(), userRepresentation.getUsername(), userRepresentation.getEmail(),
                userRepresentation.getFirstName(),  userRepresentation.getLastName());
    }




}
