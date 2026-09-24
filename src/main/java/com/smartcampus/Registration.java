package com.smartcampus;

public class Registration {
    private int registrationId;
    private int studentId;
    private int courseId;
    private String semester;

    public Registration(int registrationId, int studentId, int courseId, String semester) {
        this.registrationId = registrationId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.semester = semester;
    }

    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }
    public String getSemester() { return semester; }
}