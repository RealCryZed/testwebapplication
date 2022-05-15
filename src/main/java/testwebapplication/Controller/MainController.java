package testwebapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import testwebapplication.Functions.FileService;
import testwebapplication.Functions.FirstTaskCore;
import testwebapplication.Model.Task1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class MainController {

    @Autowired
    private FirstTaskCore firstTask;

    @Autowired
    private FileService fileService;

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();

//        ArrayList<Task> tasks = new ArrayList<>();
//        tasks.add(new Task(1, "Задача 1"));
//        tasks.add(new Task(2, "Задача 2"));
//
//        mv.addObject("tasks", tasks);
//        mv.addObject("selectedTask", new Task());

        mv.setViewName("home");
        return mv;
    }
    @GetMapping("/task/1")
    public ModelAndView task1() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("task", new Task1());
        mv.setViewName("task1");
        return mv;
    }

    @PostMapping("/task/1")
    public ModelAndView task1Result(Task1 task1) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("task", new Task1());
        mv.addObject("taskCall", "Результат:");
        mv.addObject("taskResult", firstTask.getSimilarCharacters(task1));
        mv.setViewName("task1");

        return mv;
    }

    @GetMapping("/task/2")
    public ModelAndView task2() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("task2");
        return mv;
    }

    @PostMapping("/upload")
    public ModelAndView uploadFIle(@RequestParam("file") MultipartFile file) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("task", new Task1());
        mv.addObject("taskCall", "Результат, полученный из файла ");
        mv.addObject("taskFileName", file.getOriginalFilename());
        mv.addObject("taskResult", fileService.uploadFileAndGetResult(file));
        mv.addObject("taskParameters", Arrays.asList(fileService.getContentByLines(file)));

        mv.setViewName("task1");

        return mv;
    }

    @PostMapping("/download")
    public ModelAndView importFile() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("task1");

        return mv;
    }
}
