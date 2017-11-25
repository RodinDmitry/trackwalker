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
    long id;

    String name;
    String description;
    Date createTime;
    Date receiveDate;//1
    Date startDate;
    Date prepareStartTime;//2
    ArrayList<Long> prepareImg;//3
    Date prepareEndTime;//3
    Date endManeuresTime;//4
    Date readyWatchTime;//5
    Date endWatchTime;//6
    Date acceptTime;//7
    ArrayList<Long> acceptImg;//7
    Date endConnectionTime;//8
    Date readyFillTime;//9
    Date startFillTime;//10
    Date endDisconnectionTime;//11
    Date endProbeTime;//12
    String numbers;//13
    Date readyWatchTime2;//14
    Date acceptTime2;//15
    ArrayList<Long> acceptImg2;//15
    ArrayList<Long> prepareImg2;//16
    Date prepareEndTime2; //16
    Date endManeuresTime2; //17
    Date finishTime;
    Boolean isDeleted;
}