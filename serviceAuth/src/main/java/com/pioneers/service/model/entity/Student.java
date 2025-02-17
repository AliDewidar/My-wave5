package com.pioneers.service.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;
    private String userName;
    private String password;
    private int age;
    private String email;
    private String gender;
    private boolean isLoggedIn;
}
