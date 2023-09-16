package com.digitalmedia.users.repository;

import com.digitalmedia.users.model.dto.UserDTO;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class KeycloakUserRepository {
  @Autowired
  private Keycloak keycloakClient;
  @Value("${dh.keycloak.realm}")
  private String realm;


  public List<UserDTO> findUsersNoAdmin() {
    List<UserRepresentation> usersFromKeycloak = keycloakClient.realm(realm).users().list();
    List<UserRepresentation> usersEnabled = usersFromKeycloak.stream().filter(userRepresentation -> userRepresentation.getGroups().stream().noneMatch(s -> Objects.equals(s, "ADMIN"))).collect(Collectors.toList());
    return usersEnabled.stream().map(this::toUser).collect(Collectors.toList());
  }

  private UserDTO toUser(UserRepresentation userRepresentation) {

    return new UserDTO(userRepresentation.getEmail(), userRepresentation.getUsername());
  }

}
