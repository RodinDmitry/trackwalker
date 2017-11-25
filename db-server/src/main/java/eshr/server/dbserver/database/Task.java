package eshr.server.dbserver.database;

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

    @Id
    @GeneratedValue
    public long id;

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
    public String numbers;//13
    public Date readyWatchTime2;//14
    public Date acceptTime2;//15
    public ArrayList<Long> acceptImg2;//15
    public ArrayList<Long> prepareImg2;//16
    public Date prepareEndTime2; //16
    public Date endManeuresTime2; //17
    public Date finishTime;
    public Boolean isDeleted;
}