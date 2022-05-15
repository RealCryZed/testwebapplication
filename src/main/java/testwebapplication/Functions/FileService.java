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
        Set<String> result = new HashSet<>();
        Task1 task1 = new Task1();
        try {
            String content = new String(file.getBytes());

            String[] lines = content.split("\\r?\\n");

            task1.setSequence1(lines[0]);
            task1.setSequence2(lines[1]);

            result = firstTaskCore.getSimilarCharacters(task1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
