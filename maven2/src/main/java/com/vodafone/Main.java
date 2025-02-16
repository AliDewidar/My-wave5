package com.vodafone;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int addResult = calculator.add(1, 2);
        System.out.println("addResult : "+addResult);
    }
}