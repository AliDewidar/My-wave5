package com.pioneers.errorhandling.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    private String firstName;
    private String secondName;
    private int age;
    private String gender;
    private String email;
    private String password;
}
