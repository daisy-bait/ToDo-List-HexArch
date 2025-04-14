package top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs;

import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {

    Task retrieveTask(Long taskId);

    List<Task> retrieveTasks();

}
