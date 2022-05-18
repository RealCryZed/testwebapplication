package testwebapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import testwebapplication.Functions.SecondTaskCore;
import testwebapplication.Model.Task2;

@Controller
public class Task2Controller {

    @Autowired
    private SecondTaskCore secondTaskCore;

    @GetMapping("/task/2")
    public ModelAndView task2() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("task", new Task2());
        mv.setViewName("task2");
        return mv;
    }

    @PostMapping(value = "/task/2", params = "action=calc")
    public ModelAndView task2Result() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("task", new Task2());
        mv.addObject("taskResult", secondTaskCore.getNewMagicCube());
        mv.setViewName("task2");

        return mv;
    }
}
