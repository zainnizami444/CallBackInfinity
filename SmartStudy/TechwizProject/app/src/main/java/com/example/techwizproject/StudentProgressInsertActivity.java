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
    EditText Progress_RollNo,Progress_StudentName,Progress_O_Marks,Progress_T_Marks,Progress_Percentage;
    Button btn_AddProgress;
    String Student_Progress_id;
    int Obtain_Marks,Total_Marks,Percentage;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprogressinsert);
        //Type Casting
        Progress_RollNo = findViewById(R.id.Progress_RollNo);
        Progress_StudentName = findViewById(R.id.Progress_Student_Name);
        Progress_O_Marks = findViewById(R.id.Progress_O_Marks);
        Progress_T_Marks = findViewById(R.id.Progress_T_Marks);
        Progress_Percentage = findViewById(R.id.Progress_Percentage);
        btn_AddProgress = findViewById(R.id.btn_AddProgress);

        //Adding data in Student Progress Table
        btn_AddProgress.setOnClickListener(view -> {
            db= FirebaseDatabase.getInstance("https://callinfinity-8a173-default-rtdb.firebaseio.com/").getReference("StudentProgress");
            Student_Progress_id = System.currentTimeMillis()+"";
            Obtain_Marks = Integer.parseInt(Progress_O_Marks.getText().toString());
            Total_Marks = Integer.parseInt(Progress_T_Marks.getText().toString());
            Percentage = Integer.parseInt(Progress_Percentage.getText().toString());
            StudentProgress progress = new StudentProgress(Student_Progress_id,Progress_RollNo.getText().toString(),Progress_StudentName.getText().toString()
                    ,Obtain_Marks,Total_Marks,Percentage);
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