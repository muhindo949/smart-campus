package com.smartcampus;

import com.smartcampus.UserDAO;
import com.smartcampus.User;
import com.smartcampus.AcademicService;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        AcademicService academicService = new AcademicService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("SMART CAMPUS MANAGEMENT SYSTEM");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = userDAO.authentication(username, password);

        if (user != null){
            System.out.println("\nLogin Successful! Welcome, " + user.getUsername() + " (" + user.getRole() + ")");

            if  ("Lecturer".equalsIgnoreCase(user.getRole())) {
                System.out.println("\nAcademic Marks Entry...");
                System.out.print("Enter student ID: ");
                int studentId = scanner.nextInt();
                System.out.print("Enter course ID: ");
                int courseId = scanner.nextInt();
                System.out.print("Enter coursework marks: ");
                double coursework = scanner.nextDouble();
                System.out.print("Enter Examination marks: ");
                double exam = scanner.nextDouble();

                boolean success = academicService.processAndSaveExamMarks(studentId,courseId,coursework,exam);
                if (success) {
                    System.out.println("Marks successfully processed, graded, and saved into database.");
                } else {
                    System.out.println("Invalid credentials. Access Denied.");
                }
                scanner.close();
            }
        }
    }
}