package com.example.techwizproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ShowStudentMarksAdapter extends BaseAdapter {

    // Variables
    ArrayList<Student> data;
    TextView txt_RollNo,txt_studentName,txt_studentAge,txt_EmailAddress,txt_Address;
    Button btn_AddMarks;
    Context context;
    DatabaseReference db;
    public ShowStudentMarksAdapter(ArrayList<Student> data, Context context) {
        this.data = data;
        this.context = context;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View root = LayoutInflater.from(context).inflate(R.layout.show_studentmarkscontent,null);

        txt_RollNo = root.findViewById(R.id.txt_Student_RollNo);
        txt_studentName = root.findViewById(R.id.txt_Student_Name);
        txt_studentAge = root.findViewById(R.id.txt_Student_Age);
        txt_EmailAddress = root.findViewById(R.id.txt_Student_Email_Address);
        txt_Address = root.findViewById(R.id.txt_Student_Address);
        btn_AddMarks= root.findViewById(R.id.btn_Add_Student_Marks);


        txt_RollNo.setText(data.get(i).getRollNo());
        txt_studentName.setText(data.get(i).getStudentName());
        txt_studentAge.setText(data.get(i).getStudentAge());
        txt_EmailAddress.setText(data.get(i).getEmail());
        txt_Address.setText(data.get(i).getAddress());

        //On Click
        btn_AddMarks.setOnClickListener(view1 -> {
            Intent intent = new Intent(context , EditActitvity.class);
            intent.putExtra("RollNo", data.get(i).getRollNo());
            intent.putExtra("Student_Name", data.get(i).getStudentName());


            context.startActivity(intent);
        });

        return root;
    }
}
