package top.daisy_dev.hexagonal.to_do_list.domain.ports.outputs;

import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {

    Task saveTask(Task task);

    Optional<Task> findTaskById(Long id);

    Optional<Task> updateTask(Task task);

    List<Task> findAllTasks();

    boolean deleteTaskById(Long taskId);

}
