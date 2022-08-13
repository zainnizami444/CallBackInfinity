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

public class Register_Teacher extends AppCompatActivity {
    // Variables
    EditText TeacherName,TeacherEmail,TeacherPassword,TeacherAddress;
    Button btn_RegisterTeacher;
    String TeacherId;
    DatabaseReference db;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_teacher);
        // Type Casting

        TeacherEmail = findViewById(R.id.TeacherEmail);
        TeacherPassword = findViewById(R.id.TeacherPassword);
        btn_RegisterTeacher = findViewById(R.id.btn_Register_Teacher);
        mAuth = FirebaseAuth.getInstance();
        btn_RegisterTeacher.setOnClickListener(view -> {
                mAuth.createUserWithEmailAndPassword(TeacherEmail.getText().toString(),TeacherPassword.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        Register(mAuth.getUid());
                    }
                });
            mAuth.createUserWithEmailAndPassword(TeacherEmail.getText().toString(),TeacherPassword.getText().toString()).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Register_Teacher.this,"Data Inserted Successfully",Toast.LENGTH_SHORT).show();
                }
            });

        });

    }

    public void Register(String id){
        // Type Casting
        TeacherName = findViewById(R.id.TeacherName);
        TeacherEmail = findViewById(R.id.TeacherEmail);
        TeacherPassword = findViewById(R.id.TeacherPassword);
        TeacherAddress = findViewById(R.id.TeacherAddress);
        btn_RegisterTeacher = findViewById(R.id.btn_Register_Teacher);
        TeacherId = id;
        db= FirebaseDatabase .getInstance("https://callinfinity-8a173-default-rtdb.firebaseio.com/").getReference("Teacher");
        Teacher teacher = new Teacher(TeacherId,TeacherName.getText().toString(),TeacherEmail.getText().toString(),TeacherPassword.getText().toString(),TeacherAddress.getText().toString());
        db.child(TeacherId).setValue(teacher).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(Register_Teacher.this,"Data has been inserted",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Register_Teacher.this,Login_Teacher.class);
                startActivity(intent);
            }
        });
    }
}