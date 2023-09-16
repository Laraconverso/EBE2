package com.example.keycloaklocal.repository;

import com.example.keycloaklocal.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAll();
    List<User> findByFirstName(String firstName);
    Optional<User> findById(String id);

    User deleteUserById(String id);


}
