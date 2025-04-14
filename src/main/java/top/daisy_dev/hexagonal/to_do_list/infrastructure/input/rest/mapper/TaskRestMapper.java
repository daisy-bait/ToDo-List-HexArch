package top.daisy_dev.hexagonal.to_do_list.infrastructure.input.rest.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.input.rest.dto.TaskDTO;

@Component
public class TaskRestMapper {

    private final ModelMapper modelMapper;

    public TaskRestMapper() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.typeMap(TaskDTO.class, Task.class)
                .addMapping(TaskDTO::getStartTime, Task::setCreatedAt);
        this.modelMapper.typeMap(Task.class, TaskDTO.class)
                .addMapping(Task::getCreatedAt, TaskDTO::setStartTime);
    }

    public Task toDomainModel(TaskDTO taskDTO) {
        return modelMapper.map(taskDTO, Task.class);
    }

    public TaskDTO toDto(Task task) {
        return modelMapper.map(task, TaskDTO.class);
    }

}
