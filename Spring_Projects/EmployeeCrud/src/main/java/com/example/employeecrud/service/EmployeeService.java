package com.example.employeecrud.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employeecrud.entity.employee;
import com.example.employeecrud.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public employee saveEmployee(employee emp) {
        return repo.save(emp);
    }

    public List<employee> getAllEmployees() {
        return repo.findAll();
    }

    public employee getEmployeeById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }
}