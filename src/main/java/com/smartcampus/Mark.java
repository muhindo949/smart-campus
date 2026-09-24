package com.smartcampus;

public class Mark {
    private int markId;

    private int studentId;
    private int courseId;
    private double coursework;
    private double exam;
    private double total;
    private String grade;

    public Mark(int markId, int studentId, int courseId,double coursework, double exam, double total, String grade) {
        this.markId = markId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.coursework = coursework;
        this.exam = exam;
        this.total = total;
        this.grade = grade;
    }
    //getters and setters
    public int getStudentId(){return studentId;}
    public int getCourseId() {return courseId;}
    public double getCoursework() {return coursework;}
    public double getExam() {return exam;}
    public double getTotal() {return total;}
    public void setTotal(double total) {this.total = total;}
    public String getGrade() {return grade;}
    public void setGrade(String grade) {this.grade = grade;}
}