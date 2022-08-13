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
    TextView txt_progress_rollNo,txt_progress_studentName,txt_progress_O_Marks,txt_progress_T_Marks,txt_progress_percentage;
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
        txt_progress_rollNo = root.findViewById(R.id.Progress_Student_RollNo);
        txt_progress_studentName = root.findViewById(R.id.Progress_Student_Name);
        txt_progress_O_Marks= root.findViewById(R.id.Progress_O_Marks);
        txt_progress_T_Marks = root.findViewById(R.id.Progress_Student_TotalMarks);
        txt_progress_percentage = root.findViewById(R.id.Progress_Student_Percentage);
        btn_Edit = root.findViewById(R.id.btn_Edit_Progress);
        btn_Delete = root.findViewById(R.id.btn_Delete_Progress);

        txt_progress_rollNo.setText(data.get(i).getRollNo());
        txt_progress_studentName.setText(data.get(i).getStudentName());
        txt_progress_O_Marks.setText(data.get(i).getO_marks());
        txt_progress_T_Marks.setText(""+data.get(i).getT_marks());
        txt_progress_percentage.setText(""+data.get(i).getPercentage());
        //On Click
        btn_Edit.setOnClickListener(view1 -> {
            Intent intent = new Intent(context , ProgressEditActivity.class);
            intent.putExtra("StudentProgressId", data.get(i).getStudentProgressId());
            intent.putExtra("RollNo" , data.get(i).getRollNo());
            intent.putExtra("Student_Name", data.get(i).getStudentName());
            intent.putExtra("O_Marks" , data.get(i).getO_marks()+"");
            intent.putExtra("T_Marks" , data.get(i).getT_marks()+"");
            intent.putExtra("Percentage" , data.get(i).getPercentage()+"");
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
