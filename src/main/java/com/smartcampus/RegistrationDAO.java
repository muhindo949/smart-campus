package com.smartcampus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDAO {

    public boolean registerCourse(Registration registration) {

        String query = "INSERT INTO registration " +
                       "(student_id, course_id, semester) " +
                       "VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, registration.getStudentId());
            stmt.setInt(2, registration.getCourseId());
            stmt.setString(3, registration.getSemester());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
