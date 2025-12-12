package com.skillnext2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/student_jdbc";
    private static final String USER = "root";       // change if needed
    private static final String PASSWORD = "admin";   // change if needed

    // Insert a new student
    public void insertStudent(Student student) {
        String sql = "INSERT INTO student(name, age, course, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getCourse());
            stmt.setString(4, student.getEmail());

            stmt.executeUpdate();
            System.out.println("Student inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course"),
                        rs.getString("email")
                );
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Update student by ID
    public void updateStudent(Student student) {
        String sql = "UPDATE student SET name=?, age=?, course=?, email=? WHERE student_id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getCourse());
            stmt.setString(4, student.getEmail());
            stmt.setInt(5, student.getStudentId());

            stmt.executeUpdate();
            System.out.println("Student updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete student by ID
    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM student WHERE student_id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            stmt.executeUpdate();
            System.out.println("Student deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}