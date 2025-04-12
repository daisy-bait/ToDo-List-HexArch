package top.daisy_dev.hexagonal.to_do_list.application.useCases;

import lombok.AllArgsConstructor;
import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs.CreateTaskUseCase;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.outputs.TaskRepositoryPort;

@AllArgsConstructor
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task saveTask(Task task) {
        return taskRepositoryPort.saveTask(task);
    }

}
