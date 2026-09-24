package com.smartcampus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MarkDAO {
    public boolean saveOrUpdateMark(Mark mark) {
        String query = "INSERT INTO marks (student_id, course_id, coursework, exam, total, grade) " + 
        "VALUES (?,?,?,?,?,?) " + 
        "ON DUPLICATE KEY UPDATE coursework = ?, exam = ? , total = ?, grade = ?";

        try (Connection conn = DatabaseConfig.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, mark.getStudentId());
            stmt.setInt(2, mark.getCourseId());
            stmt.setDouble(3, mark.getCoursework());
            stmt.setDouble(4, mark.getExam());
            stmt.setDouble(5, mark.getTotal());
            stmt.setString(6, mark.getGrade());

            stmt.setDouble(7,mark.getCoursework());
            stmt.setDouble(8, mark.getExam());
            stmt.setDouble(9, mark.getTotal());
            stmt.setString(10, mark.getGrade());
            return stmt.executeUpdate() > 0;
                } catch (SQLException e){
        e.printStackTrace();
            return false;
                }
    }
}