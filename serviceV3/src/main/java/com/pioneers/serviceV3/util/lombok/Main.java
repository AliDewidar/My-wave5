package com.pioneers.serviceV3.util.lombok;

public class Main {
    public static void main(String[] args) {
        StudentLombok studentLombok = new StudentLombok("Ali", 23, "ali@techpioneershub.com", "male", "123");
        StudentLombok studentLombok2 = new StudentLombok("Ali", 23, "ali@techpioneershub.com");

        System.out.println(studentLombok);
    }
}
