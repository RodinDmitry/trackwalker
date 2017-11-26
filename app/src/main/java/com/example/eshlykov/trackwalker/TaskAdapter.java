package com.example.eshlykov.trackwalker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.data_struct.Task;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by EvgenyShlykov on 25.11.2017, 025.
 */

public class TaskAdapter extends BaseAdapter {


    private ArrayList<Task> mData;
    private Context mContext;

    /**
     * our ctor for this adapter, we'll accept all the things we need here
     *
     * @param mData
     */
    public TaskAdapter(final Context context, final ArrayList<Task> mData) {
        this.mData = mData;
        this.mContext = context;
    }

    public void setData(ArrayList<Task> mData) {
        this.mData = mData;
    }

    public List<Task> getData() {
        return mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(mContext).inflate(
                    R.layout.task, parent, false);
        }
        final Task currentTask = (Task) getItem(position);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, TaskDetailedActivity.class);
                Log.d("Diction", "intenting");
                intent.putExtra("task", currentTask.getBundle());
                mContext.startActivity(intent);
            }
        });

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.start_time);
        defaultTextView.setText(currentTask.getCreateTime());

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
