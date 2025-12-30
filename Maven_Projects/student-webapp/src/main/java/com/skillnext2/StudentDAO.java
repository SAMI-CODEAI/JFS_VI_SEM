package com.skillnext2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDAO {

    public static void save(Student student) {

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/skillnext2_db",
                "root",
                "admin"
            );

            // SQL insert statement
            String sql = "INSERT INTO student(id, name, email, course, marks) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            // Set parameters from Student object
            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getCourse());
            ps.setDouble(5, student.getMarks());

            // Execute insert
            ps.executeUpdate();

            // Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}