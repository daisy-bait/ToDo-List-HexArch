package top.daisy_dev.hexagonal.to_do_list.application.useCases;

import lombok.AllArgsConstructor;
import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs.CreateTaskUseCase;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs.DeleteTaskUseCase;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.outputs.TaskRepositoryPort;

@AllArgsConstructor
public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public boolean deleteTask(Long taskId) {
        return taskRepositoryPort.deleteTaskById(taskId);
    }

}
