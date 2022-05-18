package testwebapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import testwebapplication.Functions.DBService;
import testwebapplication.Functions.FileService;
import testwebapplication.Functions.FirstTaskCore;
import testwebapplication.Model.Task1;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class Task1Controller {

    @Autowired
    private FirstTaskCore firstTask;

    @Autowired
    private FileService fileService;

    @Autowired
    private DBService dbService;

    @GetMapping("/task/1")
    public ModelAndView task1() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("task", new Task1());
        mv.setViewName("task1");
        return mv;
    }

    @PostMapping(value = "/task/1", params = "action=calc")
    public ModelAndView task1Result(Task1 task1) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("task", new Task1());
        mv.addObject("taskCall", "Результат:");
        mv.addObject("taskResult", firstTask.getSimilarCharacters(task1));
        mv.setViewName("task1");

        return mv;
    }

    @PostMapping("/upload")
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile file) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("task", new Task1());
        mv.addObject("taskCall", "Результат, полученный из файла ");
        mv.addObject("taskFileName", file.getOriginalFilename());
        mv.addObject("taskResult", fileService.uploadFileAndGetResult(file));
        mv.addObject("taskParameters", Arrays.asList(fileService.getContentByLines(file)));

        mv.setViewName("task1");

        return mv;
    }

    @PostMapping("/task/1/load-data")
    public ModelAndView loadFromDB() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("task", new Task1());
        mv.addObject("dbRecords", dbService.getDbRecords());
        mv.setViewName("task1");

        return mv;
    }

    @PostMapping("/task/1/load-data/result")
    public ModelAndView loadFromDBandCalc(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Task1 task1 = dbService.getTask(Integer.valueOf(request.getParameter("recordName")));

        mv.addObject("task", new Task1());
        mv.addObject("taskCall", "Результат:");
        mv.addObject("taskResult", firstTask.getSimilarCharacters(task1));
        mv.setViewName("task1");

        return mv;
    }

    @PostMapping(value = "/task/1", params = "action=download")
    public ResponseEntity<Resource> download(Task1 task1) throws IOException {
        return fileService.downloadFileTask1(task1);
    }

    @PostMapping(value = "/task/1", params = "action=save")
    public ModelAndView saveInBD(Task1 task1) {
        dbService.saveInDB(task1);
        ModelAndView mv = new ModelAndView();

        mv.addObject("task", new Task1());
        mv.setViewName("task1");
        return mv;
    }
}
