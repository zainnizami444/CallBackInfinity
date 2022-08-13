package com.example.techwizproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Login_Activity extends AppCompatActivity {

    Button btn_Login_teacher,btn_Login_student,btn_Login_Parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_Login_teacher = findViewById(R.id.btn_Intent_Login_Teacher);
        btn_Login_student = findViewById(R.id.btn_Intent_Login_Student);
        btn_Login_Parent = findViewById(R.id.btn_Intent_Login_Parent);

        btn_Login_teacher.setOnClickListener(view -> {
            Intent intent = new Intent(Login_Activity.this,Login_Teacher.class);
            startActivity(intent);
        });
        btn_Login_student.setOnClickListener(view -> {
            Intent intent = new Intent(Login_Activity.this,Login_Student.class);
            startActivity(intent);
        });
        btn_Login_Parent.setOnClickListener(view -> {
            Intent intent = new Intent(Login_Activity.this,Login_Parent.class);
            startActivity(intent);
        });

    }
}