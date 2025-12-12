package com.skillnext2;

import java.util.List;

public class App {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // Insert a new student
        Student s1 = new Student("Alice", 20, "Computer Science", "alice@example.com");
        dao.insertStudent(s1);

        // Fetch all students
        List<Student> students = dao.getAllStudents();
        System.out.println("All Students:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Update a student (example: update student with ID 1)
        if (!students.isEmpty()) {
            Student first = students.get(0);
            first.setCourse("Data Science");
            dao.updateStudent(first);
            System.out.println("Updated student: " + first);
        }

        // Delete a student (example: delete student with ID 2)
        if (students.size() > 1) {
            int idToDelete = students.get(1).getStudentId();
            dao.deleteStudent(idToDelete);
            System.out.println("Deleted student with ID: " + idToDelete);
        }
    }
}