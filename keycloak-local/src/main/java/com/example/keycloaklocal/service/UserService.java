package com.example.keycloaklocal.service;

import com.example.keycloaklocal.model.User;
import com.example.keycloaklocal.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public User deleteUser(String id) {
        return userRepository.deleteUserById(id);
    }


}
