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

public class MainActivity extends AppCompatActivity {
    //Variables
    EditText StudentId,StudentName,Subject,Marks;
    Button btn_AddMarks;
    String StudentMarksid;
    int StudentMarks;
    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Type Casting
        StudentId = findViewById(R.id.Student_Id);
        StudentName = findViewById(R.id.Student_Name);
        Subject = findViewById(R.id.Subject);
        Marks = findViewById(R.id.Student_Marks);
        btn_AddMarks = findViewById(R.id.btn_AddMarks);

        //Adding data in StudentMarks Table
        btn_AddMarks.setOnClickListener(view -> {
            db= FirebaseDatabase.getInstance("https://callinfinity-8a173-default-rtdb.firebaseio.com/").getReference("StudentMarks");
            StudentMarksid = System.currentTimeMillis()+"";
            StudentMarks = Integer.parseInt(Marks.getText().toString());
            StudentMarks marks = new StudentMarks(StudentMarksid,StudentId.getText().toString(),StudentName.getText().toString()
            ,Subject.getText().toString(),StudentMarks);
            // Result On Success
            db.child(StudentMarksid).setValue(marks).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override public void onSuccess(Void unused) {
                    Toast.makeText(MainActivity.this,"Inserted The Data",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this,IntentActivity.class);
                    startActivity(intent);
                }
            });
            // Result On Failure
            db.child(StudentMarksid).setValue(marks).addOnFailureListener(new OnFailureListener() {
                @Override

                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this,"Data Failed To Insert",Toast.LENGTH_SHORT).show();
                }
            });
        });



    }
}