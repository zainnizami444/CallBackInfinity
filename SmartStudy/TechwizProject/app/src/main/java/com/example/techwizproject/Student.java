package com.example.techwizproject;

public class Student {

    public String studentId;
    public String studentName;
    public String studentAge;
    public String password;
    public String address;
    public String email;
    public String rollNo;

    public Student() {
    }

    public Student(String studentId, String studentName, String studentAge, String password, String address, String email, String rollNo) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.password = password;
        this.address = address;
        this.email = email;
        this.rollNo = rollNo;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getRollNo() {
        return rollNo;
    }
}
