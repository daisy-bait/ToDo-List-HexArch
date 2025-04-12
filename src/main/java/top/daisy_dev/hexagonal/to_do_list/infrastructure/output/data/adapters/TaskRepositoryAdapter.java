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
public class TaskRepositoryAdapter {

}
