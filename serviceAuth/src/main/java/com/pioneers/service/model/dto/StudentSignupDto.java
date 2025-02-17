package com.pioneers.service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StudentSignupDto {
    private String username;
    private String password;
    private int age;
    private String email;
    private String gender;
}


