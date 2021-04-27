package ch.newaccess.backendproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ch.newaccess.backendproject.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
public List<Task> findByTaskNameContains(String taskName);
//ou
@Query("select t from Task t where t.taskName like :x")
public List<Task> rechercher(@Param("x") String taskName);

}
