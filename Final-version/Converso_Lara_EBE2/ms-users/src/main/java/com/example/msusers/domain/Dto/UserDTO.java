package com.example.msusers.domain.Dto;

import com.example.msusers.domain.Bill;
import com.example.msusers.domain.User;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserDTO {
    User user;
    List<Bill> bills;
}
