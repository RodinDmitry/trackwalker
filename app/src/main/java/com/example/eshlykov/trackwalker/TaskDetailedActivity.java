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

import com.example.data_struct.DataBase;
import com.example.data_struct.ServerInteracter;
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
        task = DataBase.getInstance(getBaseContext()).getTask(intent.getLongExtra("task", 1));
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
                    task.uploadProgress(getBaseContext());
                } else {
                    task.startDate = null;
                }
            }
        });
        CheckBox check2 = (CheckBox) findViewById(R.id.naliv_is_started);
        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox check = (CheckBox) view;
                if (check.isChecked()) {
                    task.startFillTime = new Date();
                    task.uploadProgress(getBaseContext());
                } else {
                    task.startFillTime = null;
                }
            }
        });
        CheckBox check3 = (CheckBox) findViewById(R.id.shunting_is_began);
        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox check = (CheckBox) view;
                if (check.isChecked()) {
                    task.prepareStartTime = new Date();
                    task.uploadProgress(getBaseContext());
                } else {
                    task.prepareStartTime = null;
                }
            }
        });
        CheckBox check4 = (CheckBox) findViewById(R.id.shunting_is_ended);
        check4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox check = (CheckBox) view;
                if (check.isChecked()) {
                    task.endManeuresTime = new Date();
                    task.uploadProgress(getBaseContext());
                } else {
                    task.endManeuresTime = null;
                }
            }
        });
        CheckBox check5 = (CheckBox) findViewById(R.id.viaduct_is_ready);
        check5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox check = (CheckBox) view;
                if (check.isChecked()) {
                    task.readyWatchTime = new Date();
                    task.uploadProgress(getBaseContext());
                } else {
                    task.readyWatchTime = null;
                }
            }
        });
        CheckBox check6 = (CheckBox) findViewById(R.id.vetse_is_viewed);
        check6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox check = (CheckBox) view;
                if (check.isChecked()) {
                    task.endWatchTime = new Date();
                    task.uploadProgress(getBaseContext());
                } else {
                    task.endWatchTime = null;
                }
            }
        });
        CheckBox check7 = (CheckBox) findViewById(R.id.act_is_signed);
        check7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox check = (CheckBox) view;
                if (check.isChecked()) {
                    task.acceptTime = new Date();
                    task.uploadProgress(getBaseContext());
                } else {
                    task.acceptTime = null;
                }
            }
        });
        CheckBox check8 = (CheckBox) findViewById(R.id.rnp_is_connected);
        check8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox check = (CheckBox) view;
                if (check.isChecked()) {
                    task.endConnectionTime = new Date();
                    task.uploadProgress(getBaseContext());
                } else {
                    task.endConnectionTime = null;
                }
            }
        });
        CheckBox check9 = (CheckBox) findViewById(R.id.vetse_is_ready_to_naliv);
        check9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox check = (CheckBox) view;
                if (check.isChecked()) {
                    task.readyFillTime = new Date();
                    task.uploadProgress(getBaseContext());
                } else {
                    task.readyFillTime = null;
                }
            }
        });
        CheckBox check10 = (CheckBox) findViewById(R.id.rnl_is_deconnected);
        check10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox check = (CheckBox) view;
                if (check.isChecked()) {
                    task.endDisconnectionTime = new Date();
                    task.uploadProgress(getBaseContext());
                } else {
                    task.endDisconnectionTime = null;
                }
            }
        });
        CheckBox check11 = (CheckBox) findViewById(R.id.selection_is_over);
        check11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox check = (CheckBox) view;
                if (check.isChecked()) {
                    task.endProbeTime = new Date();
                    task.uploadProgress(getBaseContext());
                } else {
                    task.endProbeTime = null;
                }
            }
        });
        CheckBox check12 = (CheckBox) findViewById(R.id.shunting_is_over);
        check12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox check = (CheckBox) view;
                if (check.isChecked()) {
                    task.endManeuresTime2 = new Date();
                    task.uploadProgress(getBaseContext());
                } else {
                    task.endManeuresTime2 = null;
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
    protected void onPause() {
        task.uploadProgress(getBaseContext());
        super.onPause();
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
