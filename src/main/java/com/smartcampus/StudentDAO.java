package com.smartcampus;

import com.smartcampus.DatabaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    public boolean addStudent(String studentNo, String name, String programme, String phone) {
        String query = " INSERT INTO students (studentNo, name, programme,phone) VALUES (?,?,?,?)";
        try (Connection conn = DatabaseConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, studentNo);
            stmt.setString(2, name);
            stmt.setString(3, programme);
            stmt.setString(4, phone);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}