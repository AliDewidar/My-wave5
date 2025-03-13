package com.pioneers.serviceV4.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class SignupDto {
    private String name;
    private int age;
    private String email;
    private String gender;
    private String password;
}