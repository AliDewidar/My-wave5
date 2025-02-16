package com.pioneers.spring.pattern.singleton;

public enum EnumDbConnection {

    INSTANCE;

    private String connectionString;

    EnumDbConnection() {
        System.out.println("I am in EnumDbConnection constructor!!");
        connectionString = "jdbc:mysql://localhost:3306/pioneers";
    }

    public static EnumDbConnection getInstance() {
        return INSTANCE;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
}
