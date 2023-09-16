package com.example.keycloaklocal.controller;

import com.example.keycloaklocal.model.User;
import com.example.keycloaklocal.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserRestController {
    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/firstname/{firstName}")
    public ResponseEntity<List<User>> findByFirstName(@PathVariable String firstName) {
        return ResponseEntity.ok(userService.findByFirstName(firstName));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        Optional<User> foundUser = userService.findById(id);
        if (foundUser.isPresent()) {
            return ResponseEntity.ok(foundUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String  id) {
        User foundUser = userService.deleteUser(id);
        if (foundUser != null) {
            return ResponseEntity.ok(foundUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
