package eshr.server.dbserver;

import eshr.server.dbserver.database.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    final TaskRepository taskRepository;

    public IndexController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/index")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Dmitry");
        return new ModelAndView("index", model);
    }

}