package com.pioneers.spring.pattern.singleton;

public class Main {
    public static void main(String[] args) {
        EagerDbConnection connection = EagerDbConnection.getInstance();
        System.out.println("connection.getConnectionString() = " + connection.getConnectionString());
    }
}
