package com.example.eshlykov.trackwalker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.data_struct.DataBase;
import com.example.data_struct.ServerInteracter;
import com.example.data_struct.Task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String operator;
    ArrayList<Task> tasks;
    TaskAdapter itemsAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, RegistrationService.class);
        startService(i);


        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.HOUR_OF_DAY, 8);
        final Date date1 = cal1.getTime();
        tasks = DataBase.getInstance(MainActivity.this.getBaseContext()).getAll();
        itemsAdapter = new TaskAdapter(this, tasks);
        listView = (ListView) findViewById(R.id.task_list);
        listView.setAdapter(itemsAdapter);

    }

    @Override
    protected void onResume() {
        operator = getSharedPreferences(SplashActivity.OPERATOR_NAME, MODE_APPEND)
                .getString(SplashActivity.OPERATOR_NAME, "");
        ServerInteracter.getInstance().getMyTasks(operator, new ServerInteracter.ListCallback() {
            @Override
            public void proceedTask(Long tid) {
                if (!DataBase.getInstance(MainActivity.this.getBaseContext()).isTaskIn(tid)) {
                    ServerInteracter.getInstance().getTask(tid, new ServerInteracter.OneCallback() {
                        @Override
                        public void proceedTask(final Task task) {
                            Log.d("Update", "updated");
                            DataBase.getInstance(MainActivity.this.getBaseContext()).addTask(task);
                            ArrayList<Task> tempTasks = new ArrayList<Task>();
                            tempTasks.add(task);
                            tempTasks.addAll(tasks);
                            tasks = tempTasks;
                            itemsAdapter.getData().clear();
                            itemsAdapter.notifyDataSetInvalidated();
                            itemsAdapter.getData().addAll(tasks);
                            itemsAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
        super.onResume();

    }
}
