package testwebapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import testwebapplication.Functions.FileService;
import testwebapplication.Functions.SecondTaskCore;
import testwebapplication.Model.Task2;

import java.io.IOException;

@Controller
public class Task2Controller {

    @Autowired
    private SecondTaskCore secondTaskCore;

    @Autowired
    private FileService fileService;

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

        int[][] magicSquare = secondTaskCore.getNewMagicSquare();

        mv.addObject("task", new Task2());
        mv.addObject("taskResult", magicSquare);
        mv.addObject("taskCost", secondTaskCore.calcSum(magicSquare));
        mv.setViewName("task2");

        return mv;
    }

    @PostMapping(value = "/task/2", params = "action=download")
    public ResponseEntity<Resource> download() throws IOException {
        return fileService.downloadFileTask2();
    }
}
