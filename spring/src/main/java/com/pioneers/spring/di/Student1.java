package com.pioneers.spring.di;

import java.util.Objects;

public class Student1 {
    private String name;
    private int age;
    private final Address address;
    // Tightly Coupled
//    private final Address address = new Address();

    // Loosely Coupled
    public Student1(Address address) {
        this.address = address;
    }

    // Tightly Coupled
    public Student1(String country, String city) {
        this.address = new Address(country, city);
    }

    public void printStudentInfo() {
        System.out.println("Student Name: " + name + ", Age: " + age + ", Address: "
                + address.getCountry() + "/" + address.getCity());
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

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student1 student = (Student1) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
