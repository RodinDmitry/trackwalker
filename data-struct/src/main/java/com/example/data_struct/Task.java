package com.example.data_struct;

import android.net.Uri;

import java.util.Date;

/**
 * Created by kozlo on 25.11.2017.
 */

public class Task {
    long id;
    String description;
    Date createTime;
    Date receiveDate;//1
    Date startDate;
    Date prepareStartTime;//2
    Uri[] prepareImg;//3
    Date prepareEndTime;//3
    Date endManeuresTime;//4
    Date readyWatchTime;//5
    Date endWatchTime;//6
    Date acceptTime;//7
    Uri[] acceptImg;//7
    Date endConnectionTime;//8
    Date readyFillTime;//9
    Date startFillTime;//10
    Date endDisconnectionTime;//11
    Date endProbeTime;//12
    Uri[] numbers;//13
    Date readyWatchTime2;//14
    Date acceptTime2;//15
    Uri[] acceptImg2;//15
    Uri[] prepareImg2;//16
    Date prepareEndTime2; //16
    Date endManeuresTime2; //17
    Date finishTime;
    Boolean isDeleted;
}
