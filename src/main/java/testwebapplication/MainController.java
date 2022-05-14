package testwebapplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();

        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, "Задача 1"));
        tasks.add(new Task(2, "Задача 2"));

        mv.addObject("tasks", tasks);
        mv.addObject("selectedTask", new Task());

        mv.setViewName("home");
        return mv;
    }

//    @PostMapping("/")
//    public ModelAndView selectTask(Task selectedTask, Model model) {
//        ModelAndView mv = new ModelAndView();
//        model.addAttribute("task", selectedTask);
//
//        System.out.println(selectedTask.getTaskName());
//
//        mv.setViewName("task1");
//        return mv;
//    }

//    @GetMapping("task")
//    public ModelAndView getTask() {
//        ModelAndView mv = new ModelAndView();
//
//        mv.setViewName("task");
//
//        return mv;
//    }

    @GetMapping("/task/1")
    public ModelAndView task1() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("task1");
        return mv;
    }

    @GetMapping("/task/2")
    public ModelAndView task2() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("task2");
        return mv;
    }

    @PostMapping("/getTask1Result")
    public ModelAndView task1Result() {
        ModelAndView mv = new ModelAndView();



        mv.setViewName("task1");
        return mv;
    }
}
