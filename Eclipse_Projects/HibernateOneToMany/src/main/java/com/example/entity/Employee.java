package com.example.entity;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // Many employees belong to one department
    @ManyToOne
    @JoinColumn(name = "department_id") // foreign key column in Employee table
    private Department department;

    // Constructors
    public Employee() {
        super();
    }

    public Employee(int id, String name, Department department) {
        super();
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }
}