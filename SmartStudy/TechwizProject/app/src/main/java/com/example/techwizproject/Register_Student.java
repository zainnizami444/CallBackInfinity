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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register_Student extends AppCompatActivity {
    // Variables
    EditText StudentName,StudentPassword,StudentAge,StudentAddress,StudentEmail,StudentRollNo;
    Button btn_RegisterStudent;
    String StudentId;
    DatabaseReference db;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        //Type Casting


        StudentPassword = findViewById(R.id.R_Student_Password);
          StudentEmail = findViewById(R.id.R_Student_Email);
        btn_RegisterStudent = findViewById(R.id.btn_Register_Student);
        mAuth = FirebaseAuth.getInstance();
        btn_RegisterStudent.setOnClickListener(view -> {
            mAuth.createUserWithEmailAndPassword(StudentEmail.getText().toString(),StudentPassword.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {

                    Register(mAuth.getUid());
                }
            });


        });

    }
    public void Register(String id){
        //Type Casting
        Toast.makeText(Register_Student.this,"Inserting Data",Toast.LENGTH_SHORT).show();
        StudentName = findViewById(R.id.R_Student_Name);
        StudentAge = findViewById(R.id.R_Student_Age);
        StudentPassword = findViewById(R.id.R_Student_Password);
        StudentAddress = findViewById(R.id.R_Student_Address);
        StudentEmail = findViewById(R.id.R_Student_Email);
        StudentRollNo = findViewById(R.id.R_Student_RollNo);
        StudentId = id;
        db= FirebaseDatabase.getInstance("https://callinfinity-8a173-default-rtdb.firebaseio.com/").getReference("Student");
        Student student = new Student(StudentId,StudentName.getText().toString(),StudentAge.getText().toString(),StudentPassword.getText().toString(),
                StudentAddress.getText().toString(),StudentEmail.getText().toString(),StudentRollNo.getText().toString());
        db.child(StudentId).setValue(student).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(Register_Student.this,"Data has been inserted",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Register_Student.this,Login_Teacher.class);
                startActivity(intent);
            }
        });
        db.child(StudentId).setValue(student).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Register_Student.this,e.toString(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}