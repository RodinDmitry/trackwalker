package com.example.data_struct;

import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kozlo on 25.11.2017.
 */

public class Task {
    String Name;
    long id;
    String description;
    Date createTime;
    Date receiveDate;//1
    Date startDate;
    Date prepareStartTime;//2
    ArrayList<Uri> prepareImg;//3
    ArrayList<Long> prepareImgId;
    Date prepareEndTime;//3
    Date endManeuresTime;//4
    Date readyWatchTime;//5
    Date endWatchTime;//6
    Date acceptTime;//7
    ArrayList<Uri> acceptImg;//7
    ArrayList<Long> acceptImgId;
    Date endConnectionTime;//8
    Date readyFillTime;//9
    Date startFillTime;//10
    Date endDisconnectionTime;//11
    Date endProbeTime;//12
    ArrayList<Uri> numbersImg;//13
    ArrayList<Long> numbersImgId;
    Date readyWatchTime2;//14
    Date acceptTime2;//15
    ArrayList<Uri> acceptImg2;//15
    ArrayList<Long> acceptImgId2;
    ArrayList<Uri> prepareImg2;//16
    ArrayList<Long> prepareImgId2;
    Date prepareEndTime2; //16
    Date endManeuresTime2; //17
    Date finishTime;
    Boolean isDeleted;

    void uploadProgress(){
        
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
}
