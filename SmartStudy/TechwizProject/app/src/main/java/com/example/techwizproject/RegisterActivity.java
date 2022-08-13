package com.example.techwizproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {
    //Variables
    Button btn_Register_Teacher,btn_Register_Student,btn_Register_Parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Type Casting
        btn_Register_Teacher = findViewById(R.id.btn_Intent_Register_Teacher);
        btn_Register_Student = findViewById(R.id.btn_Intent_Register_Student);
        btn_Register_Parent = findViewById(R.id.btn_Intent_Register_Parent);
        // Setting Intent On Buttons
        btn_Register_Teacher.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this ,Register_Teacher.class);
            startActivity(intent);
        });
        btn_Register_Student.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this,Register_Student.class);
            startActivity(intent);

        });
        btn_Register_Parent.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this,Register_Parent.class);
            startActivity(intent);

        });
    }
}