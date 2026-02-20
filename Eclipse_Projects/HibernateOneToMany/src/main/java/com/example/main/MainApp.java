package com.example.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.util.HibernateUtil;

public class MainApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getFactory().openSession();

		Department dept = new Department();
		dept.setName("director");

		Employee e1 = new Employee();
		e1.setName("Anudeep");

		Employee e2 = new Employee();
		e2.setName("Anil");

		e1.setDepartment(dept);
		e2.setDepartment(dept);

		List<Employee> empList = new ArrayList<Employee>();
		empList.add(e1);
		empList.add(e2);
		dept.setEmployees(empList);
		session.beginTransaction();
		session.persist(dept);
		session.getTransaction().commit();
		System.out.println("Department and Employees saved successfully!");
		session.close();
		HibernateUtil.getFactory().close();
	}
}
