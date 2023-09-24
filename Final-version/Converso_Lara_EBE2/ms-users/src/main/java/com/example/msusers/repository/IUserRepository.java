package com.example.msusers.repository;

import com.example.msusers.domain.User;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository {

    User findById(String id);
}
