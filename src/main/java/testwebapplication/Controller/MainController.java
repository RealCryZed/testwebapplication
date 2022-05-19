package testwebapplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("home");
        return mv;
    }

    @PostMapping("/")
    public ModelAndView selectTask(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        int taskNumber = Integer.valueOf(request.getParameter("taskNum"));

        modelAndView.setViewName("redirect:/task/" + taskNumber);
        return modelAndView;
    }
}
