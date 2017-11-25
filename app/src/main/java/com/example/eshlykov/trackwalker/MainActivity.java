package com.example.eshlykov.trackwalker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Task> tasks = new ArrayList<Task>() {{
            add(new Task("Семчик Якубовского!", new Date(), new Date()));
            add(new Task("Семчик Якубовского!", new Date(), new Date()));
            add(new Task("Семчик Якубовского!", new Date(), new Date()));
            add(new Task("Семчик Якубовского!", new Date(), new Date()));
            add(new Task("Семчик Якубовского!", new Date(), new Date()));
            add(new Task("Семчик Якубовского!", new Date(), new Date()));
            add(new Task("Семчик Якубовского!", new Date(), new Date()));
            add(new Task("Семчик Якубовского!", new Date(), new Date()));
            add(new Task("Семчик Якубовского!", new Date(), new Date()));
            add(new Task("Семчик Якубовского!", new Date(), new Date()));
        }};

        TaskAdapter itemsAdapter = new TaskAdapter(this, tasks);
        ListView listView = (ListView) findViewById(R.id.task_list);
        listView.setAdapter(itemsAdapter);
    }
}
