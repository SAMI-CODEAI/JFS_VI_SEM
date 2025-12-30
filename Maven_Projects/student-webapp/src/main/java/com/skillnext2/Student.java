package com.skillnext2;

public class Student {
    private int id;
    private String name;
    private String email;
    private String course;
    private double marks;

    // Getter and Setter for id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for course
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }

    // Getter and Setter for marks
    public double getMarks() {
        return marks;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }
}