package testwebapplication.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testwebapplication.Model.Task1;

@Repository
public interface Task1Repo extends JpaRepository<Task1, Integer> {

}
