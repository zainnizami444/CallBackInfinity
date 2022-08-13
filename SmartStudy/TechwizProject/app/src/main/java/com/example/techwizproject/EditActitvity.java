package com.example.techwizproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class EditActitvity extends AppCompatActivity {
    //Variables
    EditText   up_Subject,up_Test,up_total_marks, up_Marks,year;
    String StudentMarksId,rollNo,StudentName ;
    Button btn_update;
    int StudentMarks,total_marks , finalPercentage,result;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_actitvity);
        //Type Casting

        up_Subject = findViewById(R.id.up_Subject);
        up_Test = findViewById(R.id.up_Test);
        up_total_marks = findViewById(R.id.up_up_total_marks);
        up_Marks = findViewById(R.id.up_Marks);

        year = findViewById(R.id.up_year);
        btn_update = findViewById(R.id.btn_update);
        // Getting  Intent Values
        Intent intent =getIntent();

      rollNo = intent.getStringExtra("RollNo").toString();
    StudentName=intent.getStringExtra("Student_Name").toString();

        //On Click on update  button

        btn_update.setOnClickListener(view -> {
            StudentMarks = Integer.parseInt(up_Marks.getText().toString());
            total_marks = Integer.parseInt(up_total_marks.getText().toString());

            result = StudentMarks/total_marks*100;
            finalPercentage = result;
            StudentMarksId = System.currentTimeMillis()+"";
            db = FirebaseDatabase.getInstance("https://callinfinity-8a173-default-rtdb.firebaseio.com/").getReference("StudentMarks");
            StudentMarks up_marks = new StudentMarks(StudentMarksId,rollNo,StudentName
                    ,up_Test.getText().toString() ,up_Subject.getText().toString(),StudentMarks,total_marks,finalPercentage,year.getText().toString());
            db.child(StudentMarksId).setValue(up_marks).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(EditActitvity.this , "Updated the Data",Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(EditActitvity.this , ShowStudentMarks.class);
                    startActivity(intent1);
                }
            });
            db.child(StudentMarksId).setValue(up_marks).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(EditActitvity.this , "The data failed to update",Toast.LENGTH_SHORT).show();
                }
            });
        });

    }
}