package top.daisy_dev.hexagonal.to_do_list.application.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.daisy_dev.hexagonal.to_do_list.domain.models.AdditionalTaskInfo;
import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TaskService implements CreateTaskUseCase, UpdateTaskUseCase, RetrieveTaskUseCase, DeleteTaskUseCase, GetAdditionalTaskInfoUseCase {

    private final CreateTaskUseCase createTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    @Override
    public Task saveTask(Task task) {
        return createTaskUseCase.saveTask(task);
    }

    @Override
    public boolean deleteTask(Long taskId) {
        return deleteTaskUseCase.deleteTask(taskId);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(taskId);
    }

    @Override
    public Optional<Task> retrieveTask(Long taskId) {
        return retrieveTaskUseCase.retrieveTask(taskId);
    }

    @Override
    public List<Task> retrieveTasks() {
        return retrieveTaskUseCase.retrieveTasks();
    }

    @Override
    public Optional<Task> updateTask(Long taskId, Task toUpdateTask) {
        return updateTaskUseCase.updateTask(taskId, toUpdateTask);
    }

}
