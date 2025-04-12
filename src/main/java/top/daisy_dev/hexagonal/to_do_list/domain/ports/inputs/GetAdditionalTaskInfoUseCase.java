package top.daisy_dev.hexagonal.to_do_list.domain.ports.inputs;

import top.daisy_dev.hexagonal.to_do_list.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {

    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);

}
