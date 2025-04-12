package top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs;

public interface DeleteTaskUseCase {

    boolean deleteTask(Long taskId);

}
