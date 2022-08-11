package com.example.techwizproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowProgressActivity extends AppCompatActivity {
    //Variables
    ArrayList<StudentProgress> data;
    DatabaseReference db;
    EditText txt_search;
    Button btn_search;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_progress);
        //Type Casting
        lv = findViewById(R.id.progress_lv);
        btn_search= findViewById(R.id.btn_Progress_search);
        // Fetch data
        fetch();
        // Search data
        btn_search.setOnClickListener(view -> {
            Search();
        });
    }
    //Fetch Method
    public void fetch()
    {
        //connection String
        DatabaseReference firebaseDatabase  = FirebaseDatabase.getInstance("https://callinfinity-8a173-default-rtdb.firebaseio.com/").getReference("StudentProgress");


        data = new ArrayList<>();
        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                //load data from database in class
                for(DataSnapshot firedatabase : snapshot.getChildren())
                {
                    StudentProgress studentProgress = firedatabase.getValue(StudentProgress.class);
                    data.add(studentProgress);
                }

                ShowProgressAdapter showProgressAdapter = new ShowProgressAdapter(data,ShowProgressActivity.this);
                lv.setAdapter(showProgressAdapter);
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {


            }
        });
    }
    // Search Method
    public  void Search()
    {
        data = new ArrayList<>();
        db= FirebaseDatabase.getInstance("https://techwiz-dd3b5-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Employee");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                for (DataSnapshot firedatabase:snapshot.getChildren())
                {

                    StudentProgress studentProgress = firedatabase.getValue(StudentProgress.class);
                    if(studentProgress.studentId.contains(txt_search.getText().toString()))
                    {
                        data.add(studentProgress);
                    }
                }

                ShowProgressAdapter showProgressAdapter = new ShowProgressAdapter(data,ShowProgressActivity.this);
                lv.setAdapter(showProgressAdapter);
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}