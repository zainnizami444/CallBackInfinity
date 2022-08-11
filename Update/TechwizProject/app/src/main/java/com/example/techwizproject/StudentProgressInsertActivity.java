package com.example.techwizproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentProgressInsertActivity extends AppCompatActivity {
    //Variables
    EditText Progress_StudentId,Progress_StudentName,Progress_Subject,Progress_Marks,Progress;
    Button btn_AddProgress;
    String Student_Progress_id;
    int StudentMarks;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprogressinsert);
        //Type Casting
        Progress_StudentId = findViewById(R.id.Progress_Student_Id);
        Progress_StudentName = findViewById(R.id.Progress_Student_Name);
        Progress_Subject = findViewById(R.id.Progress_Subject);
        Progress_Marks = findViewById(R.id.Progress_Marks);
        Progress = findViewById(R.id.Pogress);
        btn_AddProgress = findViewById(R.id.btn_AddStudentProgress);

        //Adding data in Student Progress Table
        btn_AddProgress.setOnClickListener(view -> {
            db= FirebaseDatabase.getInstance("https://callinfinity-8a173-default-rtdb.firebaseio.com/").getReference("StudentProgress");
            Student_Progress_id = System.currentTimeMillis()+"";
            StudentMarks = Integer.parseInt(Progress_Marks.getText().toString());
            StudentProgress progress = new StudentProgress(Student_Progress_id,Progress_StudentId.getText().toString(),Progress_StudentName.getText().toString()
                    ,Progress_Subject.getText().toString(),StudentMarks,Progress.getText().toString());
            // Result On Success
            db.child(Student_Progress_id).setValue(progress).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override public void onSuccess(Void unused) {
                    Toast.makeText(StudentProgressInsertActivity.this,"Inserted The Data",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(StudentProgressInsertActivity.this,IntentActivity.class);
                    startActivity(intent);
                }
            });
            // Result On Failure
            db.child(Student_Progress_id).setValue(progress).addOnFailureListener(new OnFailureListener() {
                @Override

                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(StudentProgressInsertActivity.this,"Data Failed To Insert",Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}