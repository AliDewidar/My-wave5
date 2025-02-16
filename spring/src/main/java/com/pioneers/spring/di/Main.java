package com.pioneers.spring.di;

public class Main {
    public static void main(String[] args) {

        // The address is a dependency to the Student
        // Setter Injection
        Address aliAddress = new Address();
        aliAddress.setCountry("US");
        aliAddress.setCity("Las Vegas");

        // Constructor Injection
        Address hassanAddress = new Address("Egypt", "Minya");

        // Dependency (aliAddress) Injection using Constructor
        Student1 student = new Student1(aliAddress);

        // Setter Injection
        student.setName("Ali Dewidar");
        student.setAge(23);

        student.printStudentInfo();


        Student1 student1 = new Student1(hassanAddress);
        student1.setName("<NAME>");
        student1.setAge(24);

        Student1 student2 = new Student1("Egypt", "Cairo");
    }
}
