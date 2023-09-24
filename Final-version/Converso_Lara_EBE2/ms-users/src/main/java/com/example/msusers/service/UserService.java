package com.example.msusers.service;

import com.example.msusers.domain.Bill;
import com.example.msusers.domain.Dto.UserDTO;
import com.example.msusers.domain.User;
import com.example.msusers.repository.BillRepository;
import com.example.msusers.repository.KeycloakUserRepository;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final KeycloakUserRepository userRepository;
    private BillRepository billRepository;

    public UserService(KeycloakUserRepository userRepository, BillRepository billRepository) {
        this.userRepository = userRepository;
        this.billRepository = billRepository;
    }

    public UserDTO findById(String id){
        User userExtra = userRepository.findById(id);
        List<Bill> userBills = billRepository.findByUserId(id);

        UserDTO user = new UserDTO(userExtra, userBills);

        return user;
    }



}
