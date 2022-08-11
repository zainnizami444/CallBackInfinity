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

public class ProgressEditActivity extends AppCompatActivity {
    //Variables
    EditText up_StudentId , up_StudentName , up_Subject , up_Marks ,up_Progress;
    String StudentProgressId;
    Button btn_update;
    int StudentMarks;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressedit);
        //Type Casting
        up_StudentId = findViewById(R.id.up_Progress_Student_Id);
        up_StudentName = findViewById(R.id.up_Progress_StudentName);
        up_Subject = findViewById(R.id.up_Progress_Subject);
        up_Marks = findViewById(R.id.up_Progress_Marks);
        up_Progress = findViewById(R.id.up_Progress);
        btn_update = findViewById(R.id.btn_Progress_Edit);
        // Getting  Intent Values
        Intent intent =getIntent();
        StudentProgressId = intent.getStringExtra("StudentProgressId");
        up_StudentId.setText(intent.getStringExtra("Student_Id").toString());
        up_StudentName.setText(intent.getStringExtra("Student_Name").toString());
        up_Subject.setText(intent.getStringExtra("Subject").toString());
        up_Marks.setText(intent.getStringExtra("Marks").toString());
        up_Progress.setText(intent.getStringExtra("Progress").toString());
        //On Click on update  button
        btn_update.setOnClickListener(view -> {
            StudentMarks = Integer.parseInt(up_Marks.getText().toString());
            db = FirebaseDatabase.getInstance("https://callinfinity-8a173-default-rtdb.firebaseio.com/").getReference("StudentProgress");
            StudentProgress up_progress = new StudentProgress(StudentProgressId,up_StudentId.getText().toString(),up_StudentName.getText().toString()
                    ,up_Subject.getText().toString(),StudentMarks,up_Progress.getText().toString());
            db.child(StudentProgressId).setValue(up_progress).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(ProgressEditActivity.this , "Updated the Data",Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(ProgressEditActivity.this , ShowProgressActivity.class);
                    startActivity(intent1);
                }
            });
            db.child(StudentProgressId).setValue(up_progress).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(ProgressEditActivity.this , "The data failed to update",Toast.LENGTH_SHORT).show();
                }
            });
        });

    }
}