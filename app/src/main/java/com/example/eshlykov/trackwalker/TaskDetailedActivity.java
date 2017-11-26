package com.example.eshlykov.trackwalker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.data_struct.Task;

import java.util.Date;

public class TaskDetailedActivity extends AppCompatActivity {
    TextView tvView;
    Task task;
    ImageView prepareImage;

    private final int PREPARE_CODE = 1;

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
        prepareImage = (ImageView) findViewById(R.id.prepare_photo);
        Button prepare = (Button) findViewById(R.id.prepare_photo_add);
        prepare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, PREPARE_CODE);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PREPARE_CODE)
            if (resultCode == Activity.RESULT_OK) {
                Uri selectedImage = data.getData();
                task.addPreparePhoto(selectedImage, getBaseContext());
                prepareImage.setImageURI(selectedImage);
            }
    }
}
