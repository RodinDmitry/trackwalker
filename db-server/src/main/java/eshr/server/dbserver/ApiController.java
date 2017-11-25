package eshr.server.dbserver;

import com.google.gson.Gson;
import eshr.server.dbserver.database.Task;
import eshr.server.dbserver.database.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class ApiController {

    final TaskRepository taskRepository;

    public ApiController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/task/get/all")
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /*@RequestMapping(value = "/task/get/{id:.+}", method = RequestMethod.GET)
    public @ResponseBody Task getTask(@RequestParam("id") Long id) {
        return taskRepository.findOne(id);
    }*/

    @GetMapping("task/get/{id}")
    public @ResponseBody Task getTask(Long id) {
        return taskRepository.findOne(id);
    }

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

}