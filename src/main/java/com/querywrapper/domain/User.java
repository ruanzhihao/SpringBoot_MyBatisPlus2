package com.querywrapper.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    int id;
    String username;
    String password;
    String phone;
    String address;
    String score;
}