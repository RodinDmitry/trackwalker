package com.example.eshlykov.trackwalker;

import android.os.Bundle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by EvgenyShlykov on 25.11.2017, 025.
 */

public class Task {
    private String taskName = "";
    private Date startTime = new Date();
    private Date finishTime = new Date();
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
        bundle.putCharArray("taskName", taskName.toCharArray());
        bundle.putCharArray("startTime", getStartTime().toCharArray());
        bundle.putCharArray("finishTime", getFinishTime().toCharArray());
        return bundle;
    }

    public Task(Bundle bundle) {
        taskName = new String(bundle.getCharArray("taskName"));
        try {
            startTime = df.parse(new String(bundle.getCharArray("startTime")));
            finishTime = df.parse(new String(bundle.getCharArray("finishTime")));
        } catch (ParseException e) {
        }
    }

    public Task(String _taskName, Date _startTime, Date _finishTime) {
        taskName = _taskName;
        startTime = _startTime;
        finishTime = _finishTime;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStartTime() {
        return df.format(startTime);
    }

    public String getFinishTime() {
        return df.format(finishTime);
    }
}
