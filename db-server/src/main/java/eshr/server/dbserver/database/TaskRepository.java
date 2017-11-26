package eshr.server.dbserver.database;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

   /* @Modifying
    @Transactional
    @Query("UPDATE TASK SET ACCEPT_IMG=:acceptImg," +
            " ACCEPT_IMG2=:acceptImg2, " +
            "ACCEPT_TIME=:acceptTime," +
            " ACCEPT_TIME2=:acceptTime2," +
            " CREATE_TIME=:createTime," +
            " DESCRIPTION=:description," +
            " END_CONNECTION_TIME=:endConnectionTime," +
            " END_DISCONNECTION_TIME=:endDisconnectionTime," +
            " END_MANEURES_TIME=:endManeursTime," +
            " END_MANEURES_TIME2=:endManeursTime2," +
            " END_PROBE_TIME=:endProbeTime," +
            " END_WATCH_TIME=:endWatchTime," +
            " FINISH_TIME=:finishTime," +
            " IS_DELETED=:isDeleted," +
            " NAME=:name," +
            " NUMBERS=:numbers," +
            " OPERATOR=:operator," +
            " PREPARE_END_TIME=:prepareEndTime," +
            " PREPARE_END_TIME2=:prepareEndTime2," +
            " PREPARE_IMG=:prepareImg," +
            " PREPARE_IMG2=:prepareImg2," +
            " PREPARE_START_TIME=:prepareStartTime," +
            " READY_FILL_TIME=:readyFillTime," +
            " READY_WATCH_TIME=:readyWatchTime," +
            " READY_WATCH_TIME2=:readyWatchTime2," +
            " RECEIVE_DATE=:receiveDate," +
            " START_DATE=:startDate," +
            " START_FILL_TIME=:startFillTime " +
            "WHERE ID=:id")
    public void update(@Param("acceptImg") ArrayList<Long> acceptImg,
                @Param("acceptImg2") ArrayList<Long> acceptImg2,
                @Param("acceptTime") Date acceptTime,
                @Param("acceptTime2") Date acceptTime2,
                @Param("createTime") Date createTime,
                @Param("description") String description,
                @Param("endConnectionTime") Date endConnectionTime,
                @Param("endDisconnectionTime") Date endDisconnectionTime,
                @Param("endManeursTime") Date endManeursTime,
                @Param("endManeursTime2") Date endManeursTime2,
                @Param("endProbeTime") Date endProbeTime,
                @Param("endWatchTime") Date endWatchTime,
                @Param("finishTime") Date finishTime,
                @Param("isDeleted") Boolean isDeleted,
                @Param("name") String name,
                @Param("numbers") ArrayList<Long> numbers,
                @Param("operator") String operator,
                @Param("prepareEndTime") Date prepareEndTime,
                @Param("prepareEndTime2") Date prepareEndTime2,
                @Param("prepareImg") ArrayList<Long> prepareImg,
                @Param("prepareImg2") ArrayList<Long> prepareImg2,
                @Param("prepareStartTime") Date prepareStartTime,
                @Param("readyFillTime") Date readyFillTime,
                @Param("readyWatchTime") Date readyWatchTime,
                @Param("readyWatchTime2") Date readyWatchTime2,
                @Param("receiveDate") Date receiveDate,
                @Param("startDate") Date startDate,
                @Param("startFillTime") Date startFillTime,
                @Param("id") Long id);*/
}
