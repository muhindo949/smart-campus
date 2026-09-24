package com.smartcampus;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/processAndSaveExamMarks")
public class ExamMarksServlet extends HttpServlet {

    private final AcademicService academicService = new AcademicService();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        try {
            int studentId = Integer.parseInt(
                    request.getParameter("studentId")
            );

            int courseId = Integer.parseInt(
                    request.getParameter("courseId")
            );

            double coursework = Double.parseDouble(
                    request.getParameter("coursework")
            );

            double exam = Double.parseDouble(
                    request.getParameter("exam")
            );

            boolean success = academicService.processAndSaveExamMarks(
                    studentId,
                    courseId,
                    coursework,
                    exam
            );

            if (success) {
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write(
                        "Exam marks saved successfully."
                );
            } else {
                response.setStatus(
                        HttpServletResponse.SC_BAD_REQUEST
                );
                response.getWriter().write(
                        "Failed to save exam marks."
                );
            }

        } catch (NumberFormatException e) {

            response.setStatus(
                    HttpServletResponse.SC_BAD_REQUEST
            );

            response.getWriter().write(
                    "Please enter valid numeric values."
            );

        } catch (Exception e) {

            response.setStatus(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR
            );

            response.getWriter().write(
                    "Error saving exam marks: " + e.getMessage()
            );
        }
    }
}
