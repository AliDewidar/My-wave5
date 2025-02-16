package com.pioneers.datastructures.linkedlist;

public class Course {
    private int id;
    private String name;
    private int grade;
    private String department;
    private String status;

    public Course(int id, String name, int grade, String department, String status) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.department = department;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public String getDepartment() {
        return department;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", department='" + department + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
