package com.digitalmedia.users.service;

import com.digitalmedia.users.model.User;
import com.digitalmedia.users.model.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
  User validateAndGetUserExtra(String id);

  Optional<User> getUserExtra(String username);

  User saveUserExtra(User userExtra);

  List<UserDTO> getAllUsersNoAdmin();
}
