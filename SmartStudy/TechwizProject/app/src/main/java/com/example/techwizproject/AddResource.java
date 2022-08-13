package com.example.techwizproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddResource extends AppCompatActivity {
        //Variables
    EditText Resource;
    Button btn_Resource;
    DatabaseReference db;
    String ResourceId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addresource);
        //Type Casting
    Resource = findViewById(R.id.Resource);
        btn_Resource = findViewById(R.id.btn_Resource);
        btn_Resource.setOnClickListener(view -> {
            db= FirebaseDatabase.getInstance("https://callinfinity-8a173-default-rtdb.firebaseio.com/").getReference("Resource");
            ResourceId = System.currentTimeMillis()+"";
            AddStudyResources resource = new AddStudyResources(ResourceId,Resource.getText().toString());
            db.child(ResourceId).setValue(resource).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(AddResource.this,"Inserted Resources",Toast.LENGTH_SHORT).show();

                }
            });

        });
    }
}