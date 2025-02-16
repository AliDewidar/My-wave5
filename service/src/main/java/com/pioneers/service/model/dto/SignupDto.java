package com.pioneers.service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupDto {
    private String name;
    private int age;
    private String email;
    private String gender;
    private String password;
}