package com.skillnext2;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n--- Student CRUD Menu ---");
            System.out.println("1. Insert Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        Student s = new Student();
                        System.out.print("Enter name: ");
                        s.setName(sc.nextLine());
                        System.out.print("Enter email: ");
                        s.setEmail(sc.nextLine());
                        System.out.print("Enter course: ");
                        s.setCourse(sc.nextLine());
                        dao.addStudent(s);
                        System.out.println("Student inserted successfully!");
                        break;

                    case 2:
                        List<Student> list = dao.getAllStudents();
                        System.out.println("All Students:");
                        for (Student st : list) {
                            System.out.println(st);
                        }
                        break;

                    case 3:
                        Student u = new Student();
                        System.out.print("Enter rollno to update: ");
                        u.setRollno(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Enter new name: ");
                        u.setName(sc.nextLine());
                        System.out.print("Enter new email: ");
                        u.setEmail(sc.nextLine());
                        System.out.print("Enter new course: ");
                        u.setCourse(sc.nextLine());
                        dao.updateStudent(u);
                        System.out.println("Student updated successfully!");
                        break;

                    case 4:
                        System.out.print("Enter rollno to delete: ");
                        int rollno = sc.nextInt();
                        dao.deleteStudent(rollno);
                        System.out.println("Student deleted successfully!");
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}