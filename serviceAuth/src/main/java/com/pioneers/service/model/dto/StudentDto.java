package com.pioneers.service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String id;
    private String userName;
    private int age;
    private String email;
    private String gender;
    private boolean isLoggedIn;
}
