package com.example.eshlykov.trackwalker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.data_struct.Task;

import java.util.Date;

public class TaskDetailedActivity extends AppCompatActivity {
    TextView tvView;
    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detailed);

        Intent intent = getIntent();
        task = new Task(intent.getBundleExtra("task"));

        tvView = (TextView) findViewById(R.id.task_name);
        tvView.setText(task.getTaskName());
        tvView = (TextView) findViewById(R.id.start_time);
        tvView.setText(task.getCreateTime());
        tvView = (TextView) findViewById(R.id.finish_time);
        tvView.setText(task.getFinishTime());
        CheckBox check1 = (CheckBox) findViewById(R.id.task_is_got);
        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox check = (CheckBox) view;

                if (check.isChecked()) {
                    task.startDate = new Date();
                    task.uploadProgress();
                } else {
                    task.startDate = null;
                }
            }
        });

//        Для будущей стрелочки.
//        Button button = (Button) findViewById(R.id.backArrow);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                WordDescription.this.finish();
//            }
//        });
    }
}
