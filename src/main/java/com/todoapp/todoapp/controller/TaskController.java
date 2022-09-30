package com.todoapp.todoapp.controller;

import com.todoapp.todoapp.persistence.entity.Task;
import com.todoapp.todoapp.persistence.entity.TaskStatus;
import com.todoapp.todoapp.service.TaskService;
import com.todoapp.todoapp.service.dto.TaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskDTO taskDTO) {
        return this.taskService.createTask(taskDTO);
    }
    @GetMapping
    public List<Task> findAllTasks() {
        return this.taskService.findAllTasks();
    }
    @GetMapping("/status/{status}")
    public List<Task> findAllTaskByStatus(@PathVariable("status")TaskStatus status){
        return this.taskService.findAllTaskStatus(status);
    }
    @PatchMapping("/mark_finished/{id}")
    public ResponseEntity<Void> markTaskFinished(@PathVariable("id")Long id){
      this.taskService.updateTaskFinished(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id")Long id){
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
