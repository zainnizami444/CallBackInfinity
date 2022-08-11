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

public class ShowProgressAdapter extends BaseAdapter {
    // Variables
    ArrayList<StudentProgress> data;
    TextView txt_progress_studentId,txt_progress_studentName,txt_progress_subject,txt_progress_Marks,txt_progress;
    Button btn_Edit , btn_Delete;
    Context context;
    DatabaseReference db;

    public ShowProgressAdapter(ArrayList<StudentProgress> data, Context context) {
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
        txt_progress_studentId = root.findViewById(R.id.txt_Progress_StudentId);
        txt_progress_studentName = root.findViewById(R.id.txt_Progress_StudentName);
        txt_progress_subject= root.findViewById(R.id.txt_Progress_Subject);
        txt_progress_Marks = root.findViewById(R.id.txt_Progress_Marks);
        txt_progress = root.findViewById(R.id.txt_Progress);
        btn_Edit = root.findViewById(R.id.btn_Progress_Edit);
        btn_Delete = root.findViewById(R.id.btn_Progress_Delete);

        txt_progress_studentId.setText(data.get(i).getStudentId());
        txt_progress_studentName.setText(data.get(i).getStudentName());
        txt_progress_subject.setText(data.get(i).getSubject());
        txt_progress_Marks.setText(""+data.get(i).getMarks());
        txt_progress.setText(""+data.get(i).getProgress());
        //On Click
        btn_Edit.setOnClickListener(view1 -> {
            Intent intent = new Intent(context , ProgressEditActivity.class);
            intent.putExtra("StudentProgressId", data.get(i).getStudentProgressId());
            intent.putExtra("Student_Id" , data.get(i).getStudentId());
            intent.putExtra("Student_Name", data.get(i).getStudentName());
            intent.putExtra("Subject" , data.get(i).getSubject());
            intent.putExtra("Marks" , data.get(i).getMarks()+"");
            intent.putExtra("Progress" , data.get(i).getProgress());
            context.startActivity(intent);
        });
        btn_Delete.setOnClickListener(view1 -> {
            db = FirebaseDatabase.getInstance("https://callinfinity-8a173-default-rtdb.firebaseio.com/").getReference("StudentProgress");
            db.child(data.get(i).getStudentProgressId()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(context ,"Delete the data",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context , ShowProgressActivity.class);
                    context.startActivity(intent);
                }
            });
        });
        return root;
    }
}
