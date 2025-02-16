package com.pioneers.datastructures.linkedlist;

public class Project {
    private int id;
    private String Name;
    private String manager;
    private double budget;
    private String currentStatus;

    public Project(int id, String name, String manager, double budget, String currentStatus) {
        this.id = id;
        Name = name;
        this.manager = manager;
        this.budget = budget;
        this.currentStatus = currentStatus;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getManager() {
        return manager;
    }

    public double getBudget() {
        return budget;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", manager='" + manager + '\'' +
                ", budget=" + budget +
                ", currentStatus='" + currentStatus + '\'' +
                '}';
    }
}

