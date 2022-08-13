package com.example.techwizproject;

public class Teacher {

    public String teacher_Id;
    public String teacher_Name;
    public String email;
    public String password;
    public String address;

    public Teacher() {
    }

    public Teacher(String teacher_Id, String teacher_Name, String email, String password, String address) {
        this.teacher_Id = teacher_Id;
        this.teacher_Name = teacher_Name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String getTeacher_Id() {
        return teacher_Id;
    }

    public String getTeacher_Name() {
        return teacher_Name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }
}
