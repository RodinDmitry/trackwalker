package eshr.server.dbserver;

import com.google.gson.Gson;
import eshr.server.dbserver.database.Task;
import eshr.server.dbserver.database.TaskRepository;
import eshr.server.dbserver.database.Worker;
import eshr.server.dbserver.database.WorkerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class ApiController {

    final TaskRepository taskRepository;
    final WorkerRepository workerRepository;

    public ApiController(TaskRepository taskRepository,
                         WorkerRepository workerRepository) {
        this.taskRepository = taskRepository;
        this.workerRepository = workerRepository;
    }

    @GetMapping("/worker/get/all")
    public Iterable<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }



    @GetMapping("/task/get/all")
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @RequestMapping(value = "/task/get", method = RequestMethod.GET)
    public @ResponseBody Task getTask(@RequestParam("id") String id) {
        return taskRepository.findOne(Long.valueOf(id));
    }

    /*@GetMapping("task/get/{id}")
    public @ResponseBody Task getTask(Long id) {
        return taskRepository.findOne(id);
    }*/

    @RequestMapping(value = "/task/add", method = RequestMethod.POST)
    public @ResponseBody Long addTask(@RequestParam("operator") String operator,
                                      @RequestParam("name") String name,
                                      @RequestParam("description") String description) {
        Task task = new Task();
        task.name = name;
        task.operator = operator;
        task.description = description;
        task.createTime = new Date();
        taskRepository.save(task);
        return task.id;
    }

    @RequestMapping(value = "/task/update", method = RequestMethod.POST)
    public void updateTask(@RequestParam("taskJSON") String taskJSON) {
        Gson gson  = new Gson();
        Task task = gson.fromJson(taskJSON,Task.class);
        taskRepository.delete(task.id);
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/operator", method = RequestMethod.POST)
    public void updateOperator(@RequestParam("id") String id,
                             @RequestParam("operator") String operator) {
       Task task = taskRepository.findOne(Long.valueOf(id));
       task.operator = operator;
       taskRepository.delete(Long.valueOf(id));
       taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/name", method = RequestMethod.POST)
    public void updateName(@RequestParam("id") String id,
                           @RequestParam("name") String name) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.name = name;
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/description", method = RequestMethod.POST)
    public void updateDescription(@RequestParam("id") String id,
                           @RequestParam("description") String description) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.description = description;
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/receiveDate", method = RequestMethod.POST)
    public void updateReceiveDate(@RequestParam("id") String id,
                                  @RequestParam("receiveDate") Long receiveDate) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.receiveDate = new Date(receiveDate);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/startDate", method = RequestMethod.POST)
    public void updateStartDate(@RequestParam("id") String id,
                                  @RequestParam("startDate") Long startDate) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.startDate = new Date(startDate);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/prepareStartTime", method = RequestMethod.POST)
    public void updatePrepareStartTime(@RequestParam("id") String id,
                                  @RequestParam("prepareStartTime") Long prepareStartTime) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.prepareStartTime = new Date(prepareStartTime);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/prepareEndTime", method = RequestMethod.POST)
    public void updatePrepareEndTime(@RequestParam("id") String id,
                                       @RequestParam("prepareEndTime") Long prepareEndTime) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.prepareEndTime = new Date(prepareEndTime);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/endManeuresTime", method = RequestMethod.POST)
    public void updateEndManeuresTime(@RequestParam("id") String id,
                                       @RequestParam("endManeuresTime") Long endManeuresTime) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.endManeuresTime = new Date(endManeuresTime);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/readyWatchTime", method = RequestMethod.POST)
    public void updateReadyWatchTime(@RequestParam("id") String id,
                                       @RequestParam("readyWatchTime") Long readyWatchTime) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.readyWatchTime = new Date(readyWatchTime);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/endWatchTime", method = RequestMethod.POST)
    public void updateEndWatchTime(@RequestParam("id") String id,
                                       @RequestParam("endWatchTime") Long endWatchTime) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.endWatchTime = new Date(endWatchTime);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/acceptTime", method = RequestMethod.POST)
    public void updateAcceptTime(@RequestParam("id") String id,
                                       @RequestParam("acceptTime") Long acceptTime) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.acceptTime = new Date(acceptTime);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/endConnectionTime", method = RequestMethod.POST)
    public void updateEndConnectionTime(@RequestParam("id") String id,
                                 @RequestParam("endConnectionTime") Long endConnectionTime) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.endConnectionTime = new Date(endConnectionTime);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/readyFillTime", method = RequestMethod.POST)
    public void updateReadyFillTime(@RequestParam("id") String id,
                                 @RequestParam("readyFillTime") Long readyFillTime) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.readyFillTime = new Date(readyFillTime);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/startFillTime", method = RequestMethod.POST)
    public void updateStartFillTime(@RequestParam("id") String id,
                                 @RequestParam("startFillTime") Long startFillTime) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.startFillTime = new Date(startFillTime);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/endDisconnectionTime", method = RequestMethod.POST)
    public void updateEndDisconnectionTime(@RequestParam("id") String id,
                                 @RequestParam("endDisconnectionTime") Long endDisconnectionTime) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.endDisconnectionTime = new Date(endDisconnectionTime);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/endProbeTime", method = RequestMethod.POST)
    public void updateEndProbeTime(@RequestParam("id") String id,
                                           @RequestParam("endProbeTime") Long endProbeTime) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.endProbeTime = new Date(endProbeTime);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }


    @RequestMapping(value = "/task/update/readyWatchTime2", method = RequestMethod.POST)
    public void updateReadyWatchTime2(@RequestParam("id") String id,
                                   @RequestParam("readyWatchTime2") Long readyWatchTime2) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.readyWatchTime2 = new Date(readyWatchTime2);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/acceptTime2", method = RequestMethod.POST)
    public void updateAcceptTime2(@RequestParam("id") String id,
                                   @RequestParam("acceptTime2") Long acceptTime2) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.acceptTime2 = new Date(acceptTime2);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/prepareEndTime2", method = RequestMethod.POST)
    public void updatePrepareEndTime2(@RequestParam("id") String id,
                                   @RequestParam("prepareEndTime2") Long prepareEndTime2) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.prepareEndTime2 = new Date(prepareEndTime2);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/endManeuresTime2", method = RequestMethod.POST)
    public void updateEndManeuresTime2(@RequestParam("id") String id,
                                   @RequestParam("endManeuresTime2") Long endManeuresTime2) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.endManeuresTime2 = new Date(endManeuresTime2);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/finishTime", method = RequestMethod.POST)
    public void updateFinishTime(@RequestParam("id") String id,
                                   @RequestParam("finishTime") Long finishTime) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.finishTime = new Date(finishTime);
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

    @RequestMapping(value = "/task/update/isDeleted", method = RequestMethod.POST)
    public void updateIsDeleted(@RequestParam("id") String id,
                                   @RequestParam("isDeleted") Boolean isDeleted) {
        Task task = taskRepository.findOne(Long.valueOf(id));
        task.isDeleted = isDeleted;
        taskRepository.delete(Long.valueOf(id));
        taskRepository.save(task);
    }

}