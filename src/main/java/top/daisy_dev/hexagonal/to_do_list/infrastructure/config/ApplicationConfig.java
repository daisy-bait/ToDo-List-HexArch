package top.daisy_dev.hexagonal.to_do_list.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.daisy_dev.hexagonal.to_do_list.application.services.TaskService;
import top.daisy_dev.hexagonal.to_do_list.application.useCases.*;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs.GetAdditionalTaskInfoUseCase;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.outputs.ExternalServicePort;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.outputs.TaskRepositoryPort;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.adapters.ExternalServiceAdapter;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.adapters.TaskRepositoryAdapter;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.repositories.JpaTaskRepository;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(
            TaskRepositoryPort taskRepositoryPort,
            GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(TaskRepositoryAdapter taskRepositoryAdapter) {
        return taskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }

}
