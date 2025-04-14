package top.daisy_dev.hexagonal.to_do_list.infrastructure.input.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.daisy_dev.hexagonal.to_do_list.application.services.TaskService;
import top.daisy_dev.hexagonal.to_do_list.domain.models.AdditionalTaskInfo;
import top.daisy_dev.hexagonal.to_do_list.domain.models.Task;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tasks/")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/save")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task createdTask = taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable Long id) {
        Task updatedTask = taskService.updateTask(task, id);
        return ResponseEntity.status((HttpStatus.OK)).body(updatedTask);
    }

    @GetMapping("/retrieve/{taskId}")
    ResponseEntity<Task> retrieveTask(@PathVariable Long taskId) {
        Task task = taskService.retrieveTask(taskId);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/retrieve")
    ResponseEntity<List<Task>> retrieveAllTasks() {
        return ResponseEntity.ok(taskService.retrieveTasks());
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