package testwebapplication.Functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testwebapplication.Interface.Task1Repo;
import testwebapplication.Model.Task1;

import java.util.List;

@Service
public class DBService {

    @Autowired
    private Task1Repo task1Repo;

    public void saveInDB(Task1 task1) {
        task1Repo.save(task1);
    }

    public List<Task1> getDbRecords() {
        return task1Repo.findAll();
    }

    public Task1 getTask(Integer id) {
        return task1Repo.getById(id);
    }
}
