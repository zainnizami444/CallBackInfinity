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
    EditText up_StudentId , up_StudentName , up_Subject , up_Marks;
    String StudentMarksId;
    Button btn_update;
    int StudentMarks;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_actitvity);
        //Type Casting
        up_StudentId = findViewById(R.id.up_Student_Id);
        up_StudentName = findViewById(R.id.up_StudentName);
        up_Subject = findViewById(R.id.up_Subject);
        up_Marks = findViewById(R.id.up_Marks);
        btn_update = findViewById(R.id.btn_update);
        // Getting  Intent Values
        Intent intent =getIntent();
        StudentMarksId = intent.getStringExtra("MarksId");
        up_StudentId.setText(intent.getStringExtra("Student_Id").toString());
        up_StudentName.setText(intent.getStringExtra("Student_Name").toString());
        up_Subject.setText(intent.getStringExtra("Subject").toString());
        up_Marks.setText(intent.getStringExtra("Marks").toString());
        //On Click on update  button

        btn_update.setOnClickListener(view -> {
            StudentMarks = Integer.parseInt(up_Marks.getText().toString());
            db = FirebaseDatabase.getInstance("https://callinfinity-8a173-default-rtdb.firebaseio.com/").getReference("StudentMarks");
            StudentMarks up_marks = new StudentMarks(StudentMarksId,up_StudentId.getText().toString(),up_StudentName.getText().toString()
                    ,up_Subject.getText().toString(),StudentMarks);
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