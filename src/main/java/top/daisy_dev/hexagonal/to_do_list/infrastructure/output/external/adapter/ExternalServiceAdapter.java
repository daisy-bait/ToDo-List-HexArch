package top.daisy_dev.hexagonal.to_do_list.infrastructure.output.external.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.daisy_dev.hexagonal.to_do_list.domain.models.AdditionalTaskInfo;
import top.daisy_dev.hexagonal.to_do_list.domain.ports.outputs.ExternalServicePort;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.external.clients.JsonPlaceHolderClient;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.external.dto.JsonPlaceHolderTodoDTO;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.external.dto.JsonPlaceHolderUserDTO;

@AllArgsConstructor
@Component
public class ExternalServiceAdapter implements ExternalServicePort {

    private final JsonPlaceHolderClient jsonPlaceHolderClient;

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        JsonPlaceHolderTodoDTO fakeTodo = jsonPlaceHolderClient.getFakeApiTodos(taskId).getBody();

        if (fakeTodo == null) return null;

        JsonPlaceHolderUserDTO fakeUser = jsonPlaceHolderClient.getFakeApiUsers(fakeTodo.getUserId()).getBody();

        if (fakeUser == null) return null;

        return new AdditionalTaskInfo(fakeUser.getId(), fakeUser.getName(), fakeUser.getEmail(), fakeTodo.getTitle(), fakeTodo.isCompleted());
    }

}