package com.smartcampus;

import com.smartcampus.RegistrationDAO;
import com.smartcampus.Registration;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerCourse")
public class CourseRegistrationServlet extends HttpServlet {
    private RegistrationDAO registrationDAO = new RegistrationDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String semester = request.getParameter("semester");

        Registration reg = new Registration(0, studentId, courseId, semester);
        boolean isSuccess = registrationDAO.registerCourse(reg);

        if (isSuccess) {
            response.getWriter().write("Course registration complete!");
        } else {
            response.getWriter().write("Error: Registration failed. Duplicate entry or invalid ID.");
        }
    }
}