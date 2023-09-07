package com.dh.userservice.controller;

import com.dh.userservice.model.User;
import com.dh.userservice.service.UserService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/find/{id}")
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }
}
