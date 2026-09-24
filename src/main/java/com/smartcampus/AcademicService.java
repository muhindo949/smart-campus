package com.smartcampus;


public class AcademicService {
    private MarkDAO markDAO = new MarkDAO();
    public boolean processAndSaveExamMarks(int studentId, int courseId,double coursework, double exam) {
        double total = coursework + exam;
        String grade = calculateGrade(total);

        Mark mark = new Mark(0, studentId, courseId,coursework,exam,total,grade);
        return markDAO.saveOrUpdateMark(mark);
    }
    private String calculateGrade(double total) {
        if (total >= 80) return "A";
        if (total >= 70) return "B";
        if (total >= 60) return "C";
        if (total >= 50) return "D";
        return "F";
    }
}