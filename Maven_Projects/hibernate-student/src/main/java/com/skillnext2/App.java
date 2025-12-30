package com.skillnext2;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {

        // Open Hibernate session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Create a Student object
        Student student = new Student(
                "Rohit",
                "rohit@gmail.com",
                "Computer Science"
        );

        // Persist the student object
        session.persist(student);

        // Commit transaction and close session
        tx.commit();
        session.close();

        System.out.println("Student inserted successfully!");
    }
}