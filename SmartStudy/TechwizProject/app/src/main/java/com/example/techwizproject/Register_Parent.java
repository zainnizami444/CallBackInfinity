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

public class Register_Parent extends AppCompatActivity {
    // Variables
    EditText Parent_Name,Parent_Email,Parent_Password,Parent_Address;
    Button btn_Register_Parent;
    String ParentId;
    DatabaseReference db;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_parent);
        //Type Casting
        Parent_Password = findViewById(R.id.R_Parent_Password);
        Parent_Email = findViewById(R.id.R_Parent_Email);
        btn_Register_Parent = findViewById(R.id.btn_Register_Parent);
        mAuth = FirebaseAuth.getInstance();
        btn_Register_Parent.setOnClickListener(view -> {
            mAuth.createUserWithEmailAndPassword(Parent_Email.getText().toString(),Parent_Password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {

                    Register(mAuth.getUid());
                }
            });


        });
    }
    public void Register(String id){
        //Type Casting
        Toast.makeText(Register_Parent.this,"Inserting Data",Toast.LENGTH_SHORT).show();
        Parent_Name = findViewById(R.id.R_Parent_Name);
        Parent_Email = findViewById(R.id.R_Parent_Email);
        Parent_Password = findViewById(R.id.R_Parent_Password);
        Parent_Address = findViewById(R.id.R_Parent_Address);
        ParentId = id;
        db= FirebaseDatabase.getInstance("https://callinfinity-8a173-default-rtdb.firebaseio.com/").getReference("Parent");
        Parent parent = new Parent(ParentId,Parent_Name.getText().toString(),Parent_Email.getText().toString(),Parent_Password.getText().toString(),
                Parent_Address.getText().toString());
        db.child(ParentId).setValue(parent).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(Register_Parent.this,"Data has been inserted",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Register_Parent.this,Login_Teacher.class);
                startActivity(intent);
            }
        });
        db.child(ParentId).setValue(parent).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Register_Parent.this,e.toString(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}