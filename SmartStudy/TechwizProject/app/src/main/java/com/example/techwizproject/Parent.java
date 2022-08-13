package com.example.techwizproject;

public class Parent {

    public String parentId;
    public String parentName;
    public String email;
    public String password;
    public String address;

    public Parent() {
    }

    public Parent(String parentId, String parentName, String email, String password, String address) {
        this.parentId = parentId;
        this.parentName = parentName;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String getParentId() {
        return parentId;
    }

    public String getParentName() {
        return parentName;
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
