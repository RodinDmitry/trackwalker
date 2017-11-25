package com.example.data_struct;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kozlo on 25.11.2017.
 */

public class ServerTask {

    ServerTask(Task task){
        id = task.id;
        name = task.name;
        operator = task.operator;
        description = task.description;
        createTime = task.createTime;
        receiveDate = task.receiveDate;
        startDate = task.startDate;
        prepareStartTime = task.prepareStartTime;
        prepareImg = task.prepareImgId;
        prepareEndTime = task.prepareEndTime;
        endManeuresTime = task.endManeuresTime;
        readyWatchTime = task.readyWatchTime;
        endWatchTime = task.endWatchTime;
        acceptTime = task.acceptTime;
        acceptImg = task.acceptImgId;
        endConnectionTime = task.endConnectionTime;
        readyFillTime = task.readyFillTime;
        startFillTime = task.startFillTime;
        endDisconnectionTime = task.endDisconnectionTime;
        endProbeTime = task.endProbeTime;
        numbers = task.numbersImgId;
        readyWatchTime2 = task.readyWatchTime2;
        acceptTime2 = task.acceptTime2;
        acceptImg2 = task.acceptImgId2;
        prepareImg2 = task.prepareImgId2;
        prepareEndTime2 = task.prepareEndTime2;
        endManeuresTime2 = task.endManeuresTime2;
        finishTime = task.finishTime;
        isDeleted = task.isDeleted;
    }

    public long id;
    public String operator;
    public String name;
    public String description;
    public Date createTime;
    public Date receiveDate;//1
    public Date startDate;
    public Date prepareStartTime;//2
    public ArrayList<Long> prepareImg;//3
    public Date prepareEndTime;//3
    public Date endManeuresTime;//4
    public Date readyWatchTime;//5
    public Date endWatchTime;//6
    public Date acceptTime;//7
    public ArrayList<Long> acceptImg;//7
    public Date endConnectionTime;//8
    public Date readyFillTime;//9
    public Date startFillTime;//10
    public Date endDisconnectionTime;//11
    public Date endProbeTime;//12
    public ArrayList<Long> numbers;//13
    public Date readyWatchTime2;//14
    public Date acceptTime2;//15
    public ArrayList<Long> acceptImg2;//15
    public ArrayList<Long> prepareImg2;//16
    public Date prepareEndTime2; //16
    public Date endManeuresTime2; //17
    public Date finishTime;
    public Boolean isDeleted;
}
