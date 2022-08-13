package com.example.techwizproject;

public class StudentMarks {

    public String studentMarksId;
    public String rollNo ;
    public String studentName ;
    public String test_name ;
    public String subject ;
    public  int obtain_marks;
    public int total_marks;
    public int percentage;
    public String year;

    public StudentMarks() {
    }

    public StudentMarks(String studentMarksId, String rollNo, String studentName, String test_name, String subject, int obtain_marks, int total_marks, int percentage, String year) {
        this.studentMarksId = studentMarksId;
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.test_name = test_name;
        this.subject = subject;
        this.obtain_marks = obtain_marks;
        this.total_marks = total_marks;
        this.percentage = percentage;
        this.year = year;
    }

    public String getStudentMarksId() {
        return studentMarksId;
    }

    public String getRollNo() {return rollNo;}

    public String getStudentName() {
        return studentName;
    }

    public String getSubject() {
        return subject;
    }

    public String getTest_name() {
        return test_name;
    }

    public int getObtain_marks() {return obtain_marks;}

    public int getTotal_marks() {return total_marks;}

    public int getPercentage() {return percentage;}

    public String getYear() {return year;}
}
