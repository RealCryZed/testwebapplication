package testwebapplication.Functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testwebapplication.Interface.Task1Repo;
import testwebapplication.Model.Task1;

@Service
public class DBService {

    @Autowired
    private Task1Repo task1Repo;

    public void saveInDB(Task1 task1) {
//        task1.setId(999);
        System.err.println(task1);
        task1Repo.save(task1);
    }
}
