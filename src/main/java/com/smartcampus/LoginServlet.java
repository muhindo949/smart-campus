package com.smartcampus;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null ||
            username.trim().isEmpty() || password.isEmpty()) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            response.getWriter().write(
                "{"
                + "\"success\":false,"
                + "\"message\":\"Username and password are required\""
                + "}"
            );

            return;
        }

        User user = userDAO.authentication(
            username.trim(),
            password
        );

        if (user == null) {

            response.setStatus(
                HttpServletResponse.SC_UNAUTHORIZED
            );

            response.getWriter().write(
                "{"
                + "\"success\":false,"
                + "\"message\":\"Invalid username or password\""
                + "}"
            );

            return;
        }

        // Create login session
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        String role = user.getRole();

        response.setStatus(HttpServletResponse.SC_OK);

        response.getWriter().write(
            "{"
            + "\"success\":true,"
            + "\"userId\":" + user.getUserId() + ","
            + "\"username\":\"" + escapeJson(user.getUsername()) + "\","
            + "\"role\":\"" + escapeJson(role) + "\""
            + "}"
        );
    }

    private String escapeJson(String value) {

        if (value == null) {
            return "";
        }

        return value
                .replace("\\", "\\\\")
                .replace("\"", "\\\"");
    }
}