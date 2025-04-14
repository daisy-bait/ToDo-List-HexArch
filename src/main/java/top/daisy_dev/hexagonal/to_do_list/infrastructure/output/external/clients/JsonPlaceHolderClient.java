package top.daisy_dev.hexagonal.to_do_list.infrastructure.output.external.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.external.adapter.ExternalServiceAdapter;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.external.dto.JsonPlaceHolderTodoDTO;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.output.external.dto.JsonPlaceHolderUserDTO;

@FeignClient(name = "jsonPlaceHolderClient", url = "https://jsonplaceholder.typicode.com/")
public interface JsonPlaceHolderClient {

    @GetMapping("/todos/{taskId}")
    ResponseEntity<JsonPlaceHolderTodoDTO> getFakeApiTodos(@PathVariable Long taskId);

    @GetMapping("/users/{userId}")
    ResponseEntity<JsonPlaceHolderUserDTO> getFakeApiUsers(@PathVariable Long userId);

}
