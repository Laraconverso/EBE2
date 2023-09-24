package com.example.msusers.domain;


import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    public User(String id, String username, String email, String firstName, String lastName) {
    }


    private String id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private List<Bill> bill;
}
