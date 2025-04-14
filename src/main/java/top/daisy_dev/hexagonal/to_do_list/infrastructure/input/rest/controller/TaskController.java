package top.daisy_dev.hexagonal.to_do_list.infrastructure.input.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.daisy_dev.hexagonal.to_do_list.application.services.TaskService;
import top.daisy_dev.hexagonal.to_do_list.domain.models.AdditionalTaskInfo;
import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.input.rest.dto.TaskDTO;
import top.daisy_dev.hexagonal.to_do_list.infrastructure.input.rest.mapper.TaskRestMapper;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tasks/")
public class TaskController {

    private final TaskService taskService;

    private final TaskRestMapper mapper;

    @PostMapping("/save")
    public ResponseEntity<TaskDTO> saveTask(@RequestBody TaskDTO task) {
        Task createdTask = taskService.saveTask(mapper.toDomainModel(task));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(createdTask));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO task, @PathVariable Long id) {
        Task updatedTask = taskService.updateTask(mapper.toDomainModel(task), id);
        return ResponseEntity.status((HttpStatus.OK)).body(mapper.toDto(updatedTask));
    }

    @GetMapping("/retrieve/{taskId}")
    ResponseEntity<TaskDTO> retrieveTask(@PathVariable Long taskId) {
        Task task = taskService.retrieveTask(taskId);
        return ResponseEntity.ok(mapper.toDto(task));
    }

    @GetMapping("/retrieve")
    ResponseEntity<List<TaskDTO>> retrieveAllTasks() {
        return ResponseEntity.ok(
                taskService.retrieveTasks()
                        .stream()
                        .map(task -> mapper.toDto(task))
                        .collect(Collectors.toList())
        );
    }

    @DeleteMapping("/delete/{taskId}")
    ResponseEntity<Boolean> deleteTask(@PathVariable Long taskId) {
        boolean confirmDeletedTask = taskService.deleteTask(taskId);
        return ResponseEntity.status(confirmDeletedTask ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(confirmDeletedTask);
    }

    @GetMapping("/{taskId}/additional-info/")
    ResponseEntity<AdditionalTaskInfo> retrieveTaskAdditionalInfo(@PathVariable Long taskId) {
        AdditionalTaskInfo additionalInfo = taskService.getAdditionalTaskInfo(taskId);
        return ResponseEntity.ok(additionalInfo);
    }
}