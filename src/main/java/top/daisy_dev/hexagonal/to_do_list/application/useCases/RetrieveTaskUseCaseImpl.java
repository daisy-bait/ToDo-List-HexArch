package top.daisy_dev.hexagonal.to_do_list.application.useCases;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs.CreateTaskUseCase;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs.RetrieveTaskUseCase;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.outputs.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task retrieveTask(Long taskId) {
        return taskRepositoryPort.findTaskById(taskId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Task> retrieveTasks() {
        return taskRepositoryPort.findAllTasks();
    }

}
