package testwebapplication.Functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import testwebapplication.Model.Task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

@Service
public class FileService {

    @Autowired
    private FirstTaskCore firstTaskCore;

    public ResponseEntity<Resource> downloadFile(Task1 task1) throws IOException {
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

    public Set<String> uploadFileAndGetResult(MultipartFile file) {
        Task1 task1 = new Task1();

        String[] lines = getContentByLines(file);

        task1.setSequence1(lines[0]);
        task1.setSequence2(lines[1]);

        return firstTaskCore.getSimilarCharacters(task1);
    }

    public String[] getContentByLines(MultipartFile file) {
        String[] lines = new String[]{};

        try {
            String content = new String(file.getBytes());
            lines = content.split("\\r?\\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
