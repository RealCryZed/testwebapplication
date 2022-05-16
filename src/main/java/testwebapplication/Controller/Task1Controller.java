package testwebapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import testwebapplication.Functions.FileService;
import testwebapplication.Functions.FirstTaskCore;
import testwebapplication.Model.Task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Controller
public class Task1Controller {

    @Autowired
    private FirstTaskCore firstTask;

    @Autowired
    private FileService fileService;

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

    @PostMapping(value = "/task/1", params = "action=download")
    public ResponseEntity<Resource> download(Task1 task1) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/text/task1_inputs.txt"));
        String taskName = "Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.\n";

        writer.append(taskName);
        writer.append(task1.getSequence1());
        writer.append("\n");
        writer.append(task1.getSequence2());

        writer.close();

        Path path = Paths.get("src/main/resources/text/task1_inputs.txt");
        Resource resource = null;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

//    @PostMapping(value = "/task/1", params = "action=save")
//    public ResponseEntity<Resource> saveInBD(Task1 task1) throws IOException {
//
//    }
}
