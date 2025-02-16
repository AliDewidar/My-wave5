package com.pioneers.spring.pattern.singleton;

public class LazyThreadSafeDbConnection {

    private String connectionString;

    private static LazyThreadSafeDbConnection instance;

    private LazyThreadSafeDbConnection() {
        System.out.println("I am in LazyThreadSafeDbConnection constructor!!");
        connectionString = "jdbc:mysql://localhost:3306/pioneers";
    }

    public static synchronized LazyThreadSafeDbConnection getInstance() {
        if (instance == null) {
            instance = new LazyThreadSafeDbConnection();
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
