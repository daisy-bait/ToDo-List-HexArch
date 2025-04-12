package top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs;

import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;

public interface CreateTaskUseCase {

    Task saveTask(Task task);

}
