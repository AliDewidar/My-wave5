package com.pioneers.spring.model.dto;

import com.pioneers.spring.di.Address;

import java.util.Objects;

public class Teacher {
    private String name;
    private int age;
    private String department;
    private Address address;

    public Teacher() {
    }

    public Teacher(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return age == teacher.age && Objects.equals(name, teacher.name)
                && Objects.equals(department, teacher.department) && Objects.equals(address, teacher.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, department, address);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", address=" + address +
                '}';
    }
}
