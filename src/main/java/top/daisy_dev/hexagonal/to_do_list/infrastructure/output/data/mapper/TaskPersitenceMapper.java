package top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.entities.TaskEntity;

@Component
public class TaskPersitenceMapper {

    private final ModelMapper modelMapper;

    public TaskPersitenceMapper() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.typeMap(Task.class, TaskEntity.class)
                .addMapping(Task::getCreatedAt, TaskEntity::setStartDate);
        this.modelMapper.typeMap(TaskEntity.class, Task.class)
                .addMapping(TaskEntity::getStartDate, Task::setCreatedAt);
    }

    public TaskEntity toEntity(Task task) {
        return modelMapper.map(task, TaskEntity.class);
    }

    public Task toDomainModel(TaskEntity taskEntity) {
        return modelMapper.map(taskEntity, Task.class);
    }

}
