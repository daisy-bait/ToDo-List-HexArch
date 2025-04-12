package top.daisy_dev.hexagonal.to_do_list.application.useCases;

import lombok.AllArgsConstructor;
import top.daisy_dev.hexagonal.to_do_list.domain.models.AdditionalTaskInfo;
import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs.CreateTaskUseCase;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs.GetAdditionalTaskInfoUseCase;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.outputs.ExternalServicePort;

@AllArgsConstructor
public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        return externalServicePort.getAdditionalTaskInfo(taskId);
    }

}
