package top.daisy_dev.hexagonal.to_do_list.application.useCases;

import lombok.AllArgsConstructor;
import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs.CreateTaskUseCase;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs.UpdateTaskUseCase;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.outputs.TaskRepositoryPort;

import java.util.Optional;

@AllArgsConstructor
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Optional<Task> updateTask(Task toUpdateTask) {
        return taskRepositoryPort.updateTask(toUpdateTask);
    }

}
