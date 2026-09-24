package com.smartcampus;

import com.smartcampus.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminManageStudent")
public class AdminManageServlet extends HttpServlet {
    private StudentDAO studentDAO = new StudentDAO();

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
        String studentNo  = request.getParameter("studentNo");
        String name  = request.getParameter("name");
        String programme  = request.getParameter("programme");
        String phone  = request.getParameter("phone");

        boolean success = studentDAO.addStudent(studentNo, name, programme, phone);
        if (success) {
            response.getWriter().write("Admin Action: Student profile added successfully.");

        }else{
            response.getWriter().write("Error: Could not save student profile.");
        }
    }
}

