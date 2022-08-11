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
    ArrayList<StudentMarks> data;
    TextView txt_studentId,txt_studentName,txt_subject,txt_Marks;
    Button btn_Edit , btn_Delete;
    Context context;
    DatabaseReference db;
    public ShowStudentMarksAdapter(ArrayList<StudentMarks> data, Context context) {
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
        txt_studentId = root.findViewById(R.id.txt_Student_Id);
        txt_studentName = root.findViewById(R.id.txt_Student_Name);
        txt_subject= root.findViewById(R.id.txt_Subject);
        txt_Marks = root.findViewById(R.id.txt_Marks);
        btn_Edit = root.findViewById(R.id.btn_Edit);
        btn_Delete = root.findViewById(R.id.btn_Delete);

        txt_studentId.setText(data.get(i).getStudentId());
        txt_studentName.setText(data.get(i).getStudentName());
        txt_subject.setText(data.get(i).getSubject());
        txt_Marks.setText(""+data.get(i).getMarks());
        //On Click
        btn_Edit.setOnClickListener(view1 -> {
            Intent intent = new Intent(context , EditActitvity.class);
            intent.putExtra("MarksId", data.get(i).getStudentMarksId());
            intent.putExtra("Student_Id" , data.get(i).getStudentId());
            intent.putExtra("Student_Name", data.get(i).getStudentName());
            intent.putExtra("Subject" , data.get(i).getSubject());
            intent.putExtra("Marks" , data.get(i).getMarks()+"");
            context.startActivity(intent);
        });
        btn_Delete.setOnClickListener(view1 -> {
                db = FirebaseDatabase.getInstance("https://callinfinity-8a173-default-rtdb.firebaseio.com/").getReference("StudentMarks");
                db.child(data.get(i).getStudentMarksId()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(context ,"Delete the data",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context , ShowStudentMarks.class);
                        context.startActivity(intent);
                    }
                });
        });
        return root;
    }
}
