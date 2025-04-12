package top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs;

import org.springframework.scheduling.config.Task;

public interface CreateTaskUseCase {

    Task createTask(Task task);

}
