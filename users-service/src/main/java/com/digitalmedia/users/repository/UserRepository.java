package com.digitalmedia.users.repository;


import com.digitalmedia.users.model.User;
import com.digitalmedia.users.model.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
  private final IUserRepository userRepository;
  private final KeycloakUserRepository keycloakUserRepository;

  public UserRepository(IUserRepository userRepository, KeycloakUserRepository keycloakUserRepository) {
    this.userRepository = userRepository;
    this.keycloakUserRepository = keycloakUserRepository;
  }

  public User validateAndGetUser(String username) {
    return userRepository.validateAndGetUser(username);
  }

  public Optional<User> getUserExtra(String username) {
    return userRepository.getUserExtra(username);
  }

  public User saveUserExtra(User user) {
    return userRepository.saveUserExtra(user);
  }

  public List<UserDTO> findAllUsersNoAdmin() {
    return keycloakUserRepository.findUsersNoAdmin();
  }


}
