package com.example.data_struct;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kozlo on 25.11.2017.
 */

public class ServerTask {

    ServerTask(Task task){
        
    }

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
}
