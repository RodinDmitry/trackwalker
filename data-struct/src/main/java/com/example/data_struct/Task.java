package com.example.data_struct;

import android.net.Uri;
import android.os.Bundle;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kozlo on 25.11.2017.
 */

public class Task {
    public String name = "";
    public long id;
    public String operator;
    public String description;
    public Date createTime = new Date();
    public Date receiveDate;//1
    public Date startDate;
    public Date prepareStartTime;//2
    public ArrayList<Uri> prepareImg;//3
    public ArrayList<Long> prepareImgId;
    public Date prepareEndTime;//3
    public Date endManeuresTime;//4
    public Date readyWatchTime;//5
    public Date endWatchTime;//6
    public Date acceptTime;//7
    public ArrayList<Uri> acceptImg;//7
    public ArrayList<Long> acceptImgId;
    public Date endConnectionTime;//8
    public Date readyFillTime;//9
    public Date startFillTime;//10
    public Date endDisconnectionTime;//11
    public Date endProbeTime;//12
    public ArrayList<Uri> numbersImg;//13
    public ArrayList<Long> numbersImgId;
    public Date readyWatchTime2;//14
    public Date acceptTime2;//15
    public ArrayList<Uri> acceptImg2;//15
    public ArrayList<Long> acceptImgId2;
    public ArrayList<Uri> prepareImg2;//16
    public ArrayList<Long> prepareImgId2;
    public Date prepareEndTime2; //16
    public Date endManeuresTime2; //17
    public Date finishTime = new Date();
    public Boolean isDeleted;

    void uploadProgress(){
        ServerInteracter.getInstance().updateTask(new ServerTask(this));
    }

    void uploadPhoto(Uri photo, ServerInteracter.CallbackLike callback) {
        ServerInteracter.getInstance().uploadPhoto(new File(photo.getPath()), callback);
    }

    void uploadPhotos(){
        while (prepareImg.size() > prepareImgId.size()) {
            final int pid = prepareImgId.size();
            uploadPhoto(prepareImg.get(pid), new ServerInteracter.CallbackLike() {
                @Override
                public void onResponse(Long id) {
                    prepareImgId.add(pid, id);
                    uploadPhotos();
                }
            });
        }
        while (prepareImg2.size() > prepareImgId2.size()) {
            final int pid = prepareImgId2.size();
            uploadPhoto(prepareImg2.get(pid), new ServerInteracter.CallbackLike() {
                @Override
                public void onResponse(Long id) {
                    prepareImgId2.add(pid, id);
                    uploadPhotos();
                }
            });
        }
        while (acceptImg.size() > acceptImgId.size()) {
            final int pid = acceptImgId.size();
            uploadPhoto(acceptImg.get(pid), new ServerInteracter.CallbackLike() {
                @Override
                public void onResponse(Long id) {
                    acceptImgId.add(pid, id);
                    uploadPhotos();
                }
            });
        }
        while (acceptImg2.size() > acceptImgId2.size()) {
            final int pid = acceptImgId2.size();
            uploadPhoto(acceptImg2.get(pid), new ServerInteracter.CallbackLike() {
                @Override
                public void onResponse(Long id) {
                    acceptImgId2.add(pid, id);
                    uploadPhotos();
                }
            });
        }
        while (numbersImg.size() > numbersImgId.size()) {
            final int pid = numbersImgId.size();
            uploadPhoto(numbersImg.get(pid), new ServerInteracter.CallbackLike() {
                @Override
                public void onResponse(Long id) {
                    numbersImgId.add(pid, id);
                    uploadPhotos();
                }
            });
        }
    }

    public Boolean taskIsGot = false;
    public Boolean shuntingIsBegan = false;
    public Boolean shuntingIsReady = false;
    public Boolean shuntingIsEnded = false;
    public Boolean viaductIsReady = false;
    public Boolean vetseIsVieved = false;
    public Boolean actIsSigned = false;
    public Boolean rnpIsConnected = false;
    public Boolean vetseIsReadyToNaliv = false;
    public Boolean nalivIsStarted = false;
    public Boolean rnlIsDeconnected = false;
    public Boolean selectionIsOver = false;
    public Boolean shuntingIsOver = false;

    DateFormat df = new SimpleDateFormat("HH:mm");

    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharArray("taskName", name.toCharArray());
        bundle.putCharArray("createTime", getCreateTime().toCharArray());
        bundle.putCharArray("finishTime", getFinishTime().toCharArray());
        return bundle;
    }

    public Task(Bundle bundle) {
        name = new String(bundle.getCharArray("taskName"));
        try {
            createTime = df.parse(new String(bundle.getCharArray("createTime")));
            finishTime = df.parse(new String(bundle.getCharArray("finishTime")));
        } catch (ParseException e) {
        }
    }

    public Task(String _taskName, Date _createTime, Date _finishTime) {
        name = _taskName;
        createTime = _createTime;
        finishTime = _finishTime;
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
