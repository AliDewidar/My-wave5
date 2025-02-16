package com.pioneers.datastructures.linkedlist;

public class ProjectReport {
    private int id;
    private String projectName;
    private String managerName;
    private double budget;
    private String currentStatus;

    public ProjectReport(int id, String projectName, String managerName, double budget, String currentStatus) {
        this.id = id;
        this.projectName = projectName;
        this.managerName = managerName;
        this.budget = budget;
        this.currentStatus = currentStatus;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }
    public String getCurrentStatus() { return currentStatus; }
    public void setCurrentStatus(String currentStatus) { this.currentStatus = currentStatus; }

    @Override
    public String toString() {
        return "ProjectReport{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", managerName='" + managerName + '\'' +
                ", budget=" + budget +
                ", currentStatus='" + currentStatus + '\'' +
                '}';
    }
}

