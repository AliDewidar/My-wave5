package com.pioneers.spring.config;

import java.util.Objects;

public class ApplicationContext {
    private String ip = "localhost";
    private int port;
    private String dbName;
    private String dbUrl;
    private String dbPassword;

    public ApplicationContext() {
        System.out.println("I am in ApplicationContext Constructor!!");
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationContext that = (ApplicationContext) o;
        return port == that.port && Objects.equals(ip, that.ip) && Objects.equals(dbName, that.dbName)
                && Objects.equals(dbUrl, that.dbUrl) && Objects.equals(dbPassword, that.dbPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port, dbName, dbUrl, dbPassword);
    }

    @Override
    public String toString() {
        return "ApplicationContext{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", dbName='" + dbName + '\'' +
                ", dbUrl='" + dbUrl + '\'' +
                ", dbPassword='" + dbPassword + '\'' +
                '}';
    }
}
