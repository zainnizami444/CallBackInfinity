package com.example.techwizproject;

public class StudentProgress {
    public String studentProgressId;
    public String studentId ;
    public String studentName ;
    public String subject ;
    public  int marks;
    public String progress;

    public StudentProgress() {
    }

    public StudentProgress(String studentProgressId, String studentId, String studentName, String subject, int marks, String progress) {
        this.studentProgressId = studentProgressId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.subject = subject;
        this.marks = marks;
        this.progress = progress;
    }

    public String getStudentProgressId() {
        return studentProgressId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSubject() {
        return subject;
    }

    public int getMarks() {
        return marks;
    }

    public String getProgress() {
        return progress;
    }
}
