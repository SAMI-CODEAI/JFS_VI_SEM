package com.skillnext2;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    private static void insertStudent(Session session, Scanner sc) {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter course: ");
        String course = sc.nextLine();

        Transaction tx = session.beginTransaction();
        Student student = new Student(name, email, course);
        session.persist(student);
        tx.commit();

        System.out.println("Student inserted successfully!");
    }

    private static void viewStudents(Session session) {
        List<Student> students = session.createQuery("from Student", Student.class).list();
        System.out.println("---- Student Records ----");
        for (Student s : students) {
            System.out.println(s.getRollno() + " | " + s.getName() + " | " + s.getEmail() + " | " + s.getCourse());
        }
    }

    private static void updateStudent(Session session, Scanner sc) {
        System.out.print("Enter rollno to update: ");
        int rollno = Integer.parseInt(sc.nextLine());

        Student student = session.get(Student.class, rollno);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter new name: ");
        student.setName(sc.nextLine());
        System.out.print("Enter new email: ");
        student.setEmail(sc.nextLine());
        System.out.print("Enter new course: ");
        student.setCourse(sc.nextLine());

        Transaction tx = session.beginTransaction();
        session.update(student);
        tx.commit();

        System.out.println("Student updated successfully!");
    }

    private static void deleteStudent(Session session, Scanner sc) {
        System.out.print("Enter rollno to delete: ");
        int rollno = Integer.parseInt(sc.nextLine());

        Student student = session.get(Student.class, rollno);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        Transaction tx = session.beginTransaction();
        session.delete(student);
        tx.commit();

        System.out.println("Student deleted successfully!");
    }

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student CRUD Menu ---");
            System.out.println("1. Insert Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: insertStudent(session, sc); break;
                case 2: viewStudents(session); break;
                case 3: updateStudent(session, sc); break;
                case 4: deleteStudent(session, sc); break;
                case 5: 
                    session.close();
                    sc.close();
                    System.out.println("Exiting...");
                    return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}