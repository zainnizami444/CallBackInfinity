package com.example.techwizproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class IntentActivity extends AppCompatActivity {
        // Variables
    Button btn_AddStudentMarks,btn_ShowStudentMarks,btn_AddProgress,btn_ShowProgress,btn_AddOthers,btn_ShowOthers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        //Type Casting
        btn_AddStudentMarks = findViewById(R.id.btn_AddStudentMarks);
        btn_ShowStudentMarks = findViewById(R.id.btn_ShowStudentMarks);


        //Intent to Their Activity
        btn_AddStudentMarks.setOnClickListener(view -> {
            Intent  intent = new Intent(IntentActivity.this,MainActivity.class);
            startActivity(intent);
        });
        btn_ShowStudentMarks.setOnClickListener(view -> {
            Intent intent = new Intent(IntentActivity.this,ShowStudentMarks.class);
            startActivity(intent);
        });
    }
}