package com.pioneers.service.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class Student {
    @NonNull private String id;
    @NonNull public String name;
    @NonNull public int age;
    @NonNull public String email;
    @NonNull private String gender;
    @NonNull private String password;
    private boolean isLoggedIn;
}
