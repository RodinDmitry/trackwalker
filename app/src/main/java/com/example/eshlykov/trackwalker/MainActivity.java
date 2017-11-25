package com.example.eshlykov.trackwalker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.HOUR_OF_DAY, 8);
        final Date date1 = cal1.getTime();
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.HOUR_OF_DAY, 10);
        final Date date2 = cal2.getTime();
        ArrayList<Task> tasks = new ArrayList<Task>() {{
            add(new Task("Семчик Якубовского!", date1, date2));
        }};

        TaskAdapter itemsAdapter = new TaskAdapter(this, tasks);
        ListView listView = (ListView) findViewById(R.id.task_list);
        listView.setAdapter(itemsAdapter);
    }
}
