package com.pioneers.MySecondTaskE4_task5.model.entity;

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
