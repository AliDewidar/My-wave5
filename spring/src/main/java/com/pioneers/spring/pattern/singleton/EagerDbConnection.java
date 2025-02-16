package com.pioneers.spring.pattern.singleton;

public class EagerDbConnection {

    private String connectionString;

    private static final EagerDbConnection instance = new EagerDbConnection();

    private EagerDbConnection() {
        System.out.println("I am in EagerDbConnection constructor!!");
        connectionString = "jdbc:mysql://localhost:3306/pioneers";
    }

    public static EagerDbConnection getInstance() {
        return instance;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
}
