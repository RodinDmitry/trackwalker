package com.example.eshlykov.trackwalker;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.data_struct.Task;

import java.util.ArrayList;

/**
 * Created by EvgenyShlykov on 25.11.2017, 025.
 */

public class TaskAdapter extends ArrayAdapter<Task> {
    public TaskAdapter(Activity context, ArrayList<Task> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.task, parent, false);
        }
        final Task currentTask = getItem(position);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TaskDetailedActivity.class);
                Log.d("Diction", "intenting");
                intent.putExtra("task", currentTask.getBundle());
                getContext().startActivity(intent);
            }
        });

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.start_time);
        defaultTextView.setText(currentTask.getCreateTime();

        TextView russianTextView = (TextView) listItemView.findViewById(R.id.finish_time);
        russianTextView.setText(currentTask.getFinishTime());

        // Вроде, будет нужно, если захотим удалять.
//        Button deleteButton = (Button) listItemView.findViewById(R.id.delete_task);
//        deleteButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DataBase.getInstance(getContext()).delete(currentTask);
//                TaskAdapter.this.remove(currentTask);
//            }
//        });

        return listItemView;
    }

}
