package top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.adapters;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.outputs.TaskRepositoryPort;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.entities.TaskEntity;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.repositories.JpaTaskRepository;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class TaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;

    @Override
    public Task saveTask(Task task) {
        TaskEntity taskEntity = TaskEntity.toEntity(task);
        TaskEntity savedTask = jpaTaskRepository.save(taskEntity);
        return savedTask.toDomainModel();
    }

    @Override
    public Optional<Task> findTaskById(Long taskId) {
        Optional<Task> taskModel = jpaTaskRepository.findById(taskId).map(taskEntity -> taskEntity.toDomainModel());
        return taskModel;
    }

    @Override
    public List<Task> findAllTasks() {
        List<Task> taskModels = jpaTaskRepository.findAll().stream()
                .map(taskEntity -> taskEntity.toDomainModel())
                .toList();
        return taskModels;
    }

    @Override
    public Optional<Task> updateTask(Task task, Long id) {
        if (jpaTaskRepository.existsById(id)) {
            TaskEntity taskEntity = TaskEntity.toEntity(task);
            TaskEntity updatedTask = jpaTaskRepository.save(taskEntity);
            return this.findTaskById(id);
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteTaskById(Long taskId) {
        if (jpaTaskRepository.existsById(taskId)) {
            jpaTaskRepository.deleteById(taskId);
            return true;
        }
        return false;
    }

}