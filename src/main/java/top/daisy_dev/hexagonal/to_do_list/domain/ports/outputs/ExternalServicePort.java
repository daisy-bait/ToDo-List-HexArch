package top.daisy_dev.hexagonal.to_do_list.domain.ports.outputs;

import top.daisy_dev.hexagonal.to_do_list.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {

    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);

}
