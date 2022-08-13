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
    EditText up_RollNo , up_StudentName  , up_O_Marks, up_T_Marks ,up_Percentage;
    String StudentProgressId;
    Button btn_update;
    int Obtain_Marks,Total_Marks,Percentage;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressedit);
        //Type Casting
        up_RollNo = findViewById(R.id.up_Progress_RollNo);
        up_StudentName = findViewById(R.id.up_Progress_StudentName);
        up_O_Marks = findViewById(R.id.Progress_O_Marks);
        up_T_Marks = findViewById(R.id.up_Progress_T_Marks);
        up_Percentage = findViewById(R.id.up_Progress_Percentage);
        btn_update = findViewById(R.id.btn_Progress_update);
        // Getting  Intent Values
        Intent intent =getIntent();
        StudentProgressId = intent.getStringExtra("StudentProgressId");
        up_RollNo.setText(intent.getStringExtra("RollNo").toString());
        up_StudentName.setText(intent.getStringExtra("Student_Name").toString());
        up_O_Marks.setText(intent.getStringExtra("O_Marks").toString());
        up_T_Marks.setText(intent.getStringExtra("T_Marks").toString());
        up_Percentage.setText(intent.getStringExtra("Percentage").toString());
        //On Click on update  button
        btn_update.setOnClickListener(view -> {
            Obtain_Marks = Integer.parseInt(up_O_Marks.getText().toString());
            Total_Marks = Integer.parseInt(up_T_Marks.getText().toString());
            Percentage = Integer.parseInt(up_Percentage.getText().toString());
            db = FirebaseDatabase.getInstance("https://callinfinity-8a173-default-rtdb.firebaseio.com/").getReference("StudentProgress");
            StudentProgress up_progress = new StudentProgress(StudentProgressId,up_RollNo.getText().toString(),up_StudentName.getText().toString()
                    ,Obtain_Marks,Total_Marks,Percentage);
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