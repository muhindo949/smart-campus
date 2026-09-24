package com.smartcampus;

import com.smartcampus.DatabaseConfig;
import com.smartcampus.Attendance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttendanceDAO {
    public boolean recordAttendance(Attendance att) {
        String query = "INSERT INTO attendance (student_id, course_id, date, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, att.getStudentId());
            stmt.setInt(2, att.getCourseId());
            stmt.setString(3, att.getDate());
            stmt.setString(4, att.getStatus());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}