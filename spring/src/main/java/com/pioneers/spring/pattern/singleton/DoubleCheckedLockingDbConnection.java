package com.pioneers.spring.pattern.singleton;

public class DoubleCheckedLockingDbConnection {

    private String connectionString;

    private static DoubleCheckedLockingDbConnection instance;

    private DoubleCheckedLockingDbConnection() {
        System.out.println("I am in DoubleCheckedLockingDbConnection constructor!!");
        connectionString = "jdbc:mysql://localhost:3306/pioneers";
    }

    public static DoubleCheckedLockingDbConnection getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingDbConnection.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingDbConnection();
                }
            }
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
