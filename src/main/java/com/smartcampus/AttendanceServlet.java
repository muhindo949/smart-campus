package com.smartcampus;

import com.smartcampus.AttendanceDAO;
import com.smartcampus.Attendance;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/recordAttendance")
public class AttendanceServlet extends HttpServlet {
    private AttendanceDAO attendanceDAO = new AttendanceDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        Attendance att = new Attendance(0, studentId, courseId, date, status);
        boolean isSuccess = attendanceDAO.recordAttendance(att);

        if (isSuccess) {
            response.getWriter().write("Attendance successfully updated.");
        } else {
            response.getWriter().write("Error: Could not save attendance logs.");
        }
    }
}