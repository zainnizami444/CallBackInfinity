package com.example.techwizproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowStudentMarks extends AppCompatActivity {

    //Variables
    ArrayList<StudentMarks> data;
    DatabaseReference db;
    Context context;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student_marks);
        lv = findViewById(R.id.lv);
        fetch();
    }
    public void fetch()
    {
        //connection String
        DatabaseReference firebaseDatabase  = FirebaseDatabase.getInstance("https://callinfinity-8a173-default-rtdb.firebaseio.com/").getReference("StudentMarks");


        data = new ArrayList<>();
        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                //load data from database in class
                for(DataSnapshot firedatabase : snapshot.getChildren())
                {
                  StudentMarks studentMarks = firedatabase.getValue(StudentMarks.class);
                    data.add(studentMarks);
                }

                ShowStudentMarksAdapter showStudentMarksAdapter = new ShowStudentMarksAdapter(data,ShowStudentMarks.this);
                lv.setAdapter(showStudentMarksAdapter);
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {


            }
        });
    }

}