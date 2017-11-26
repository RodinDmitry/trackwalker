package com.example.data_struct;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kozlo on 25.11.2017.
 */

public class Task {
    public String name = "";
    public long id = 1;
    public String operator;
    public String description;
    public Date createTime = new Date();
    public Date receiveDate;//1
    public Date startDate;
    public Date prepareStartTime;//2
    public ArrayList<Uri> prepareImg = new ArrayList<>();//3
    public ArrayList<Long> prepareImgId = new ArrayList<>();
    public Date prepareEndTime;//3
    public Date endManeuresTime;//4
    public Date readyWatchTime;//5
    public Date endWatchTime;//6
    public Date acceptTime;//7
    public ArrayList<Uri> acceptImg = new ArrayList<>();//7
    public ArrayList<Long> acceptImgId = new ArrayList<>();
    public Date endConnectionTime;//8
    public Date readyFillTime;//9
    public Date startFillTime;//10
    public Date endDisconnectionTime;//11
    public Date endProbeTime;//12
    public ArrayList<Uri> numbersImg = new ArrayList<>();//13
    public ArrayList<Long> numbersImgId = new ArrayList<>();
    public Date readyWatchTime2;//14
    public Date acceptTime2;//15
    public ArrayList<Uri> acceptImg2 = new ArrayList<>();//15
    public ArrayList<Long> acceptImgId2 = new ArrayList<>();
    public ArrayList<Uri> prepareImg2 = new ArrayList<>();//16
    public ArrayList<Long> prepareImgId2 = new ArrayList<>();
    public Date prepareEndTime2; //16
    public Date endManeuresTime2; //17
    public Date finishTime = new Date();
    public Boolean isDeleted = false;

    Task(ServerTask task) {
        name = task.name;
        id = task.id;
        operator = task.operator;
        description = task.description;
        createTime = task.createTime;
    }

    public void addNumberPhoto(Uri img, Context context) {
        numbersImg.add(img);
        int ind = numbersImg.size();
        uploadPhotos(context);
        if (numbersImgId.size() > ind)
            DataBase.getInstance(context).addPhoto(this, "numbersImg", numbersImgId.get(ind), ind, img);
        else
            DataBase.getInstance(context).addPhoto(this, "numbersImg", null, ind, img);
    }

    public void addPreparePhoto(Uri img, Context context) {
        prepareImg.add(img);
        final int ind = prepareImg.size() - 1;

        uploadPhoto(prepareImg.get(ind), new ServerInteracter.CallbackLike() {
            @Override
            public void onResponse(Long id) {
                prepareImgId.add(ind, id);
            }
        }, context);
        if (prepareImgId.size() > ind)
            DataBase.getInstance(context).addPhoto(this, "prepareImg", prepareImgId.get(ind), ind, img);
        else
            DataBase.getInstance(context).addPhoto(this, "prepareImg", null, ind, img);
    }


    public void uploadProgress(final Context context){
        ServerInteracter.getInstance().updateTask(new ServerTask(this), new ServerInteracter.ListCallback() {
            @Override
            public void proceedTask(Long tid) {
                Task.this.id = tid;
                DataBase.getInstance(context).updateTask(Task.this);
            }
        });

    }

    public String getPath(Uri uri, Context context) {
        String[] projection = {MediaStore.MediaColumns.DATA};
        Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();
        String imagePath = cursor.getString(column_index);

        return cursor.getString(column_index);
    }

    void uploadPhoto(Uri photo, ServerInteracter.CallbackLike callback, Context context) {
        ServerInteracter.getInstance().uploadPhoto(new File(getPath(photo, context)), callback);
    }

    public void uploadPhotos(Context context){
        int iter = prepareImgId.size();
        while (prepareImg.size() > iter) {
            final int pid = prepareImgId.size();
            uploadPhoto(prepareImg.get(pid), new ServerInteracter.CallbackLike() {
                @Override
                public void onResponse(Long id) {
                    prepareImgId.add(pid, id);
                }
            }, context);
            iter++;
        }
        iter = prepareImgId2.size();
        while (prepareImg2.size() > prepareImgId2.size()) {
            final int pid = prepareImgId2.size();
            uploadPhoto(prepareImg2.get(pid), new ServerInteracter.CallbackLike() {
                @Override
                public void onResponse(Long id) {
                    prepareImgId2.add(pid, id);
                }
            }, context);
        }
        iter = acceptImgId.size();
        while (acceptImg.size() > acceptImgId.size()) {
            final int pid = acceptImgId.size();
            uploadPhoto(acceptImg.get(pid), new ServerInteracter.CallbackLike() {
                @Override
                public void onResponse(Long id) {
                    acceptImgId.add(pid, id);
                }
            }, context);
        }
        iter = acceptImgId.size();
        while (acceptImg2.size() > acceptImgId2.size()) {
            final int pid = acceptImgId2.size();
            uploadPhoto(acceptImg2.get(pid), new ServerInteracter.CallbackLike() {
                @Override
                public void onResponse(Long id) {
                    acceptImgId2.add(pid, id);
                }
            }, context);
        }
        while (numbersImg.size() > numbersImgId.size()) {
            final int pid = numbersImgId.size();
            uploadPhoto(numbersImg.get(pid), new ServerInteracter.CallbackLike() {
                @Override
                public void onResponse(Long id) {
                    numbersImgId.add(pid, id);
                }
            }, context);
        }
    }

    DateFormat df = new SimpleDateFormat("HH:mm");

    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharArray("taskName", name.toCharArray());
        bundle.putCharArray("createTime", getCreateTime().toCharArray());
        return bundle;
    }

    public Task(Bundle bundle) {
        name = new String(bundle.getCharArray("taskName"));
        try {
            createTime = df.parse(new String(bundle.getCharArray("createTime")));
        } catch (ParseException e) {
        }
    }

    public Task(){};

    public Task(String _taskName, Date _createTime) {

        name = _taskName;
        createTime = _createTime;
    }

    public String getTaskName() {
        return name;
    }

    public String getCreateTime() {
        return df.format(createTime);
    }

    public String getFinishTime() {
        return df.format(finishTime);
    }
}
