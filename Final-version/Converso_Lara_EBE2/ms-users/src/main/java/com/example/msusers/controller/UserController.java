package com.example.msusers.controller;

import com.example.msusers.domain.Dto.UserDTO;
import com.example.msusers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/userId/{id}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }


}
