package com.pioneers.datastructures.set;

import com.pioneers.datastructures.linkedlist.Student;

import java.util.*;

public class EqualsAndHashCode {
    public static void main(String[] args) {
        Student student1 = new Student(1,"Ali",23,"male","ali.com");
        Student student2 = new Student(2,"Ali",24,"male","ali2.com");

        if (student1.equals(student2)) {
            System.out.println("student1 is equal to student2");
        } else {
            System.out.println("student1 is not equal to student2");
        }
        System.out.println("student1.hashCode() = " + student1.hashCode());
        System.out.println("student2.hashCode() = " + student2.hashCode());

        Set<Student> studentSet = new HashSet<>(Arrays.asList(student1,student2));
        System.out.println("studentSet = " + studentSet);


        List<Integer> studentList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        studentList.stream()
                .map(element -> element * 2)
                .forEach(System.out::println);
    }
}
