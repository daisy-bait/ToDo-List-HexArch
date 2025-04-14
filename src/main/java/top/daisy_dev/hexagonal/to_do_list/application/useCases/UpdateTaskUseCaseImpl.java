package top.daisy_dev.hexagonal.to_do_list.application.useCases;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs.UpdateTaskUseCase;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.outputs.TaskRepositoryPort;

@AllArgsConstructor
public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task updateTask(Task toUpdateTask, Long id) throws EntityNotFoundException {
        toUpdateTask.setCreatedAt(taskRepositoryPort.findTaskById(id).get().getCreatedAt());
        toUpdateTask.setId(id);
        return taskRepositoryPort.updateTask(toUpdateTask, id)
                .orElseThrow(EntityNotFoundException::new);
    }

}
