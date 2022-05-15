package testwebapplication.Functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import testwebapplication.Model.Task1;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class FileService {

    @Autowired
    private FirstTaskCore firstTaskCore;

    public void downloadFile() {

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
