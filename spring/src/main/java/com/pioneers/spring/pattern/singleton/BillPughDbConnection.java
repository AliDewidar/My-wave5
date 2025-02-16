package com.pioneers.spring.pattern.singleton;

public class BillPughDbConnection {

    private String connectionString;

    private static class BillPughSingletonHelper {
        private static final BillPughDbConnection INSTANCE = new BillPughDbConnection();
    }

    private BillPughDbConnection() {
        System.out.println("I am in BillPughDbConnection constructor!!");
        connectionString = "jdbc:mysql://localhost:3306/pioneers";
    }

    public static BillPughDbConnection getInstance() {
        return BillPughSingletonHelper.INSTANCE;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
}
