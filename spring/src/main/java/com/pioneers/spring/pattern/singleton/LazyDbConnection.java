package com.pioneers.spring.pattern.singleton;

public class LazyDbConnection {

    private String connectionString;

    private static LazyDbConnection instance;

    private LazyDbConnection() {
        System.out.println("I am in LazyDbConnection constructor!!");
        connectionString = "jdbc:mysql://localhost:3306/pioneers";
    }

    public static LazyDbConnection getInstance() {
        if (instance == null) {
            instance = new LazyDbConnection();
        }
        return instance;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
}
