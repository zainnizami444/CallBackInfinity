package com.example.techwizproject;

public class StudentProgress {
    public String studentProgressId;
    public String rollNo ;
    public String studentName ;
    public  int o_marks;
    public  int t_marks;
    public  int percentage;


    public StudentProgress() {
    }

    public StudentProgress(String studentProgressId, String rollNo, String studentName, int o_marks, int t_marks, int percentage) {
        this.studentProgressId = studentProgressId;
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.o_marks = o_marks;
        this.t_marks = t_marks;
        this.percentage = percentage;

    }

    public String getStudentProgressId() {
        return studentProgressId;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getO_marks() {
        return o_marks;
    }

    public int getT_marks() {
        return t_marks;
    }

    public int getPercentage() {
        return percentage;
    }

}
