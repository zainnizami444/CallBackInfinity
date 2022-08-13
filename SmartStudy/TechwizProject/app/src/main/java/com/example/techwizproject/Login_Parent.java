package com.example.techwizproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Parent extends AppCompatActivity {
    //Variables
    EditText Email,Password;
    Button btn_Login,btn_Register_Your_Self;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_parent);
        Email = findViewById(R.id.Login_Teacher_Email);
        Password = findViewById(R.id.Login_Teacher_Password);
        btn_Login = findViewById(R.id.btn_Login_Teacher);
        btn_Register_Your_Self = findViewById(R.id.btn_Register_Your_Self_Teacher);
        mAuth = FirebaseAuth.getInstance();
        // Login Work

        btn_Login.setOnClickListener(view -> {
            mAuth.signInWithEmailAndPassword(Email.getText().toString(),Password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(Login_Parent.this,"Logged In",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login_Parent.this,IntentActivity.class);
                    startActivity(intent);
                }
            });

        });
        btn_Register_Your_Self.setOnClickListener(view -> {
            Intent intent = new Intent(Login_Parent.this , RegisterActivity.class);
            startActivity(intent);
        });
    }
}