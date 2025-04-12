package top.daisy_dev.hexagonal.to_do_list.infrastructure.output.data.adapters;

import org.springframework.stereotype.Component;
import top.daisy_dev.hexagonal.to_do_list.domain.models.AdditionalTaskInfo;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.outputs.ExternalServicePort;

@Component
public class ExternalServiceAdapter implements ExternalServicePort {

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        return null;
    }

}
