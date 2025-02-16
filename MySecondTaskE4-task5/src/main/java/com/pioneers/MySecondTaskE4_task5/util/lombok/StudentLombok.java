package com.pioneers.MySecondTaskE4_task5.util.lombok;


import lombok.*;

@Value
@ToString(of = { "name", "age", "email" })
public class StudentLombok {
    //    @ToString.Include
    @NonNull
    private String name;
    //    @ToString.Include
    @NonNull
    private int age;
    @NonNull
    private String email;
    //    @ToString.Exclude
    private String gender;
    //    @ToString.Exclude
    private String password;

}
