package com.example.techwizproject;

public class StudentMarks {

    public String studentMarksId;
    public String studentId ;
    public String studentName ;
    public String subject ;
    public  int marks;

    public StudentMarks() {
    }

    public StudentMarks(String studentMarksId, String studentId, String studentName, String subject, int marks) {
        this.studentMarksId = studentMarksId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.subject = subject;
        this.marks = marks;
    }

    public String getStudentMarksId() {
        return studentMarksId;
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
}
