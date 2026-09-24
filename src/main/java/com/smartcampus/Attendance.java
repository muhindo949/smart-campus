package com.smartcampus;

import java.io.Serializable;

public class Attendance implements Serializable {
    private int attendanceId;
    private int studentId;
    private int courseId;
    private String date;
    private String status;

    public Attendance(int attendanceId, int studentId, int courseId, String date, String status) {
        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
        this.status = status;
    }

    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
}