package eshr.server.dbserver;

import com.google.gson.Gson;
import eshr.server.dbserver.database.StorageService;
import eshr.server.dbserver.database.Task;
import eshr.server.dbserver.database.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApiController {

    final TaskRepository taskRepository;
    final StorageService storageService;

    @Autowired
    public ApiController(TaskRepository taskRepository,
                         StorageService storageService) {
        this.taskRepository = taskRepository;
        this.storageService = storageService;
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
    public @ResponseBody Long addTask(@RequestParam("name") String name,
                                      @RequestParam("description") String description) {
        Task task = new Task();
        task.name = name;
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


    @GetMapping("/files/all")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }


}