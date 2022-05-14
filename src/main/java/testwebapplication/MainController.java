package testwebapplication;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();

        ArrayList<String> listOfTasks = new ArrayList<>();
        listOfTasks.add("Задача 1");
        listOfTasks.add("Задача 2");

        FirstTask.inArray();

        mv.setViewName("home");
        mv.addObject("tasks", listOfTasks);

        return mv;
    }

    @PostMapping("/select")
    public ModelAndView select(@RequestParam("task") String task) {
        ModelAndView mv = new ModelAndView();
        System.out.println(task);
        mv.setViewName("redirect:/");


        return mv;
    }
}
