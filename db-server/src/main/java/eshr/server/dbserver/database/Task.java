package eshr.server.dbserver.database;

import com.google.gson.annotations.Expose;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kozlo on 25.11.2017.
 */

@Entity
public class Task {

    @Expose
    @Id
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
}