package com.example.data_struct;


import com.google.gson.annotations.Expose;

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

    @Expose
    public long id;
    @Expose
    public String operator;
    @Expose
    public String name;
    @Expose
    public String description;
    @Expose
    public Date createTime;
    @Expose
    public Date receiveDate;//1
    @Expose
    public Date startDate;
    @Expose
    public Date prepareStartTime;//2
    @Expose
    public ArrayList<Long> prepareImg;//3
    @Expose
    public Date prepareEndTime;//3
    @Expose
    public Date endManeuresTime;//4
    @Expose
    public Date readyWatchTime;//5
    @Expose
    public Date endWatchTime;//6
    @Expose
    public Date acceptTime;//7
    @Expose
    public ArrayList<Long> acceptImg;//7
    @Expose
    public Date endConnectionTime;//8
    @Expose
    public Date readyFillTime;//9
    @Expose
    public Date startFillTime;//10
    @Expose
    public Date endDisconnectionTime;//11
    @Expose
    public Date endProbeTime;//12
    @Expose
    public ArrayList<Long> numbers;//13
    @Expose
    public Date readyWatchTime2;//14
    @Expose
    public Date acceptTime2;//15
    @Expose
    public ArrayList<Long> acceptImg2;//15
    @Expose
    public ArrayList<Long> prepareImg2;//16
    @Expose
    public Date prepareEndTime2; //16
    @Expose
    public Date endManeuresTime2; //17
    @Expose
    public Date finishTime;
    @Expose
    public Boolean isDeleted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getPrepareStartTime() {
        return prepareStartTime;
    }

    public void setPrepareStartTime(Date prepareStartTime) {
        this.prepareStartTime = prepareStartTime;
    }

    public ArrayList<Long> getPrepareImg() {
        return prepareImg;
    }

    public void setPrepareImg(ArrayList<Long> prepareImg) {
        this.prepareImg = prepareImg;
    }

    public Date getPrepareEndTime() {
        return prepareEndTime;
    }

    public void setPrepareEndTime(Date prepareEndTime) {
        this.prepareEndTime = prepareEndTime;
    }

    public Date getEndManeuresTime() {
        return endManeuresTime;
    }

    public void setEndManeuresTime(Date endManeuresTime) {
        this.endManeuresTime = endManeuresTime;
    }

    public Date getReadyWatchTime() {
        return readyWatchTime;
    }

    public void setReadyWatchTime(Date readyWatchTime) {
        this.readyWatchTime = readyWatchTime;
    }

    public Date getEndWatchTime() {
        return endWatchTime;
    }

    public void setEndWatchTime(Date endWatchTime) {
        this.endWatchTime = endWatchTime;
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public ArrayList<Long> getAcceptImg() {
        return acceptImg;
    }

    public void setAcceptImg(ArrayList<Long> acceptImg) {
        this.acceptImg = acceptImg;
    }

    public Date getEndConnectionTime() {
        return endConnectionTime;
    }

    public void setEndConnectionTime(Date endConnectionTime) {
        this.endConnectionTime = endConnectionTime;
    }

    public Date getReadyFillTime() {
        return readyFillTime;
    }

    public void setReadyFillTime(Date readyFillTime) {
        this.readyFillTime = readyFillTime;
    }

    public Date getStartFillTime() {
        return startFillTime;
    }

    public void setStartFillTime(Date startFillTime) {
        this.startFillTime = startFillTime;
    }

    public Date getEndDisconnectionTime() {
        return endDisconnectionTime;
    }

    public void setEndDisconnectionTime(Date endDisconnectionTime) {
        this.endDisconnectionTime = endDisconnectionTime;
    }

    public Date getEndProbeTime() {
        return endProbeTime;
    }

    public void setEndProbeTime(Date endProbeTime) {
        this.endProbeTime = endProbeTime;
    }

    public ArrayList<Long> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Long> numbers) {
        this.numbers = numbers;
    }

    public Date getReadyWatchTime2() {
        return readyWatchTime2;
    }

    public void setReadyWatchTime2(Date readyWatchTime2) {
        this.readyWatchTime2 = readyWatchTime2;
    }

    public Date getAcceptTime2() {
        return acceptTime2;
    }

    public void setAcceptTime2(Date acceptTime2) {
        this.acceptTime2 = acceptTime2;
    }

    public ArrayList<Long> getAcceptImg2() {
        return acceptImg2;
    }

    public void setAcceptImg2(ArrayList<Long> acceptImg2) {
        this.acceptImg2 = acceptImg2;
    }

    public ArrayList<Long> getPrepareImg2() {
        return prepareImg2;
    }

    public void setPrepareImg2(ArrayList<Long> prepareImg2) {
        this.prepareImg2 = prepareImg2;
    }

    public Date getPrepareEndTime2() {
        return prepareEndTime2;
    }

    public void setPrepareEndTime2(Date prepareEndTime2) {
        this.prepareEndTime2 = prepareEndTime2;
    }

    public Date getEndManeuresTime2() {
        return endManeuresTime2;
    }

    public void setEndManeuresTime2(Date endManeuresTime2) {
        this.endManeuresTime2 = endManeuresTime2;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
