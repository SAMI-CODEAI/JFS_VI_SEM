package com.example.employeecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeecrud.entity.employee;

public interface EmployeeRepository extends JpaRepository<employee, Integer> {
	

}