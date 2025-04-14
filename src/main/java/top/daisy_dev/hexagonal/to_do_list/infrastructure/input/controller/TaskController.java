package top.daisy_dev.hexagonal.to_do_list.infrastructure.input.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.daisy_dev.hexagonal.to_do_list.application.services.TaskService;
import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tasks/")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/save")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task createdTask = taskService.saveTask(task);
        return ResponseEntity.ok(createdTask);
    }


}