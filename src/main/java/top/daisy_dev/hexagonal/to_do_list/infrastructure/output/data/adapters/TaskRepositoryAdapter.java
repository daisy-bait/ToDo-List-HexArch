package top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.outputs.TaskRepositoryPort;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.entities.TaskEntity;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.mapper.TaskPersitenceMapper;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.repositories.JpaTaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;

    private final TaskPersitenceMapper mapper;

    @Override
    public Task saveTask(Task task) {
        Task savedTask = mapper.toDomainModel(jpaTaskRepository.save(mapper.toEntity(task)));
        return savedTask;
    }

    @Override
    public Optional<Task> findTaskById(Long taskId) {
        Optional<Task> taskModel = jpaTaskRepository.findById(taskId).map(taskEntity -> mapper.toDomainModel(taskEntity));
        return taskModel;
    }

    @Override
    public List<Task> findAllTasks() {
        List<Task> taskModels = jpaTaskRepository.findAll().stream()
                .map(taskEntity -> mapper.toDomainModel(taskEntity))
                .collect(Collectors.toList());
        return taskModels;
    }

    @Override
    public Optional<Task> updateTask(Task toUpdateTask, Long id) {
            jpaTaskRepository.save(mapper.toEntity(toUpdateTask));
            return this.findTaskById(id);
    }

    @Override
    public void deleteTaskById(Long taskId) {
            jpaTaskRepository.deleteById(taskId);
    }

}