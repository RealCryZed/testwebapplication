package testwebapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private FirstTaskCore firstTask;

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
        System.out.println(task1);
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
}
