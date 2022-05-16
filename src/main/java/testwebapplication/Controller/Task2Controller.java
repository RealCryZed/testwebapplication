package testwebapplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Task2Controller {

    @GetMapping("/task/2")
    public ModelAndView task2() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("task2");
        return mv;
    }
}
