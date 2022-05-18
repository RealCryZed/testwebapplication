package testwebapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import testwebapplication.Functions.FileService;
import testwebapplication.Functions.FirstTaskCore;
import testwebapplication.Model.Task1;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

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
